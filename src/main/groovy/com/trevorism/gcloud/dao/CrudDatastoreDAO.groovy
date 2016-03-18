package com.trevorism.gcloud.dao

import com.google.appengine.api.datastore.DatastoreService
import com.google.appengine.api.datastore.DatastoreServiceFactory
import com.google.appengine.api.datastore.Entity
import com.google.appengine.api.datastore.EntityNotFoundException
import com.google.appengine.api.datastore.FetchOptions
import com.google.appengine.api.datastore.Key
import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.PreparedQuery
import com.google.appengine.api.datastore.Query

/**
 * @author tbrooks
 */
class CrudDatastoreDAO implements DatastoreDAO {

    private final DatastoreService datastore
    private final String kind

    CrudDatastoreDAO(String kind){
        this.kind = kind
        datastore = DatastoreServiceFactory.getDatastoreService()
    }

    @Override
    Entity create(Map<String, Object> data) {
        validateId(data)

        Entity entity = setEntityFromJSONObject(kind, data)
        Key key = datastore.put(entity)
        return createReturnEntity(key, entity)
    }

    private static void validateId(Map<String, Object> jsonObject) {
        if(!jsonObject["id"])
            return;

        def id = jsonObject["id"]
        try{
            Long.parseLong(id.toString())
        }catch(Exception e){
            throw new RuntimeException("Invalid ID. ID must be a number: ${id}", e)
        }
    }

    @Override
    Entity read(long id) {
        Key key = KeyFactory.createKey(kind, id)
        try{
            return datastore.get(key)
        }catch(EntityNotFoundException enfe){
            return null
        }
    }

    @Override
    List<Entity> readAll() {
        Query query = new Query(kind)
        PreparedQuery resultSet = datastore.prepare(query);
        return resultSet.asList(FetchOptions.Builder.withDefaults())
    }

    @Override
    Entity update(long id, Map<String, Object> data) {
        Entity entityExists = read(id)

        if(!entityExists)
            return null

        data.put("id", id)
        Entity entity = setEntityFromJSONObject(kind, data)
        Key key = datastore.put(entity)
        return createReturnEntity(key, entity)
    }

    @Override
    Entity delete(long id) {
        Key key = KeyFactory.createKey(kind, id)
        Entity entity = read(id)
        if(entity)
            datastore.delete(key)
        return entity
    }

    private Entity setEntityFromJSONObject(String kind, Map<String, Object> data) {
        Entity entity = createEmptyEntity(kind, data)
        data.each { k,v ->
            entity.setIndexedProperty(k.toLowerCase(), v)
        }
        entity
    }

    private static Entity createReturnEntity(Key key, Entity entity) {
        Entity returnEntity = new Entity(key)
        returnEntity.setPropertiesFrom(entity)
        return returnEntity
    }

    private static Entity createEmptyEntity(String kind, Map<String, Object> data) {
        long id = getIdFromObject(data)

        if (id != 0)
            return new Entity(kind, id)
        else
            return new Entity(kind)

    }

    private static long getIdFromObject(Map<String, Object> jsonObject) {
        try{
            if(jsonObject.containsKey("id"))
                return Long.valueOf(jsonObject.get("id").toString())
            return 0
        }catch (Exception e){
            return 0
        }
    }
}