package com.trevorism.gcloud.webapi

import com.google.appengine.api.datastore.DatastoreService
import com.google.appengine.api.datastore.DatastoreServiceFactory
import com.google.appengine.api.datastore.Entity
import com.google.appengine.api.datastore.Key
import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.PreparedQuery
import com.google.appengine.api.datastore.Query
import com.trevorism.gcloud.convert.TimedEventEntityConverter
import com.trevorism.gcloud.model.TimedEvent

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/timedevent")
class CrudController {

    private final DatastoreService datastore

    public CrudController(){
        datastore = DatastoreServiceFactory.getDatastoreService()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TimedEvent getTimedEvent(@PathParam("id") long id){
        Key key = TimedEventEntityConverter.createKeyForTimedEvent(id)
        return TimedEventEntityConverter.convert(datastore.get(key))
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TimedEvent> getAllTimedEvents(@PathParam("id") long id){
        Query query = new Query("TimedEvent")
        PreparedQuery resultSet = datastore.prepare(query);

        return resultSet.asIterable().collect{
            TimedEventEntityConverter.convert(it)
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TimedEvent createTimedEvent(TimedEvent timer){
        timer.start = new Date();
        Key key = datastore.put(TimedEventEntityConverter.convert(timer))
        timer.id = key.id
        return timer
    }

}
