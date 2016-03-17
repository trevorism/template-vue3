package com.trevorism.gcloud.webapi

import com.google.appengine.api.datastore.DatastoreService
import com.google.appengine.api.datastore.DatastoreServiceFactory
import com.google.appengine.api.datastore.Entity
import com.google.appengine.api.datastore.FetchOptions
import com.google.appengine.api.datastore.Key
import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.PreparedQuery
import com.google.appengine.api.datastore.Query
import com.trevorism.gcloud.dao.CrudDatastoreDAO
import com.trevorism.gcloud.dao.DatastoreDAO
import org.json.JSONObject

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
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
    Entity create(@PathParam("kind") String kind, def data){
        DatastoreDAO dao = new CrudDatastoreDAO(kind)
        def entity = dao.create(data)
        return entity

    }

    @PUT
    @Path("{kind}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Entity update(@PathParam("kind") String kind, @PathParam("id") long id, JSONObject data){
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
