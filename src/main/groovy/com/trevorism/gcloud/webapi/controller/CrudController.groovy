package com.trevorism.gcloud.webapi.controller

import com.google.appengine.api.datastore.Entity
import com.trevorism.gcloud.dao.CrudDatastoreDAO
import com.trevorism.gcloud.dao.DatastoreDAO
import com.trevorism.gcloud.webapi.filter.Created

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("")
class CrudController {

    @GET
    @Path("{kind}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Entity read(@PathParam("kind") String kind, @PathParam("id") long id){
        DatastoreDAO dao = new CrudDatastoreDAO(kind)
        def entity = dao.read(id)
        return entity
    }

    @GET
    @Path("{kind}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Entity> readAll(@PathParam("kind") String kind){
        DatastoreDAO dao = new CrudDatastoreDAO(kind)
        def entities = dao.readAll()
        return entities
    }


    @POST
    @Path("{kind}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Created
    Entity create(@PathParam("kind") String kind, Map<String, Object> data){
        DatastoreDAO dao = new CrudDatastoreDAO(kind)
        def entity = dao.create(data)
        return entity

    }

    @PUT
    @Path("{kind}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Entity update(@PathParam("kind") String kind, @PathParam("id") long id, Map<String, Object> data){
        DatastoreDAO dao = new CrudDatastoreDAO(kind)
        def entity = dao.update(id, data)
        return entity

    }

    @DELETE
    @Path("{kind}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Entity delete(@PathParam("kind") String kind, @PathParam("id") long id){
        DatastoreDAO dao = new CrudDatastoreDAO(kind)
        def entity = dao.delete(id)
        return entity
    }

}
