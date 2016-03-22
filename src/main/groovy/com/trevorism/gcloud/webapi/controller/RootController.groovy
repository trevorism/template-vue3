package com.trevorism.gcloud.webapi.controller

import com.google.appengine.api.datastore.DatastoreService
import com.google.appengine.api.datastore.DatastoreServiceFactory
import com.google.appengine.api.datastore.Entities
import com.google.appengine.api.datastore.Query

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/")
class RootController {

    private final DatastoreService datastore = DatastoreServiceFactory.getDatastoreService()

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getEndpoints(){
        Query query = new Query(Entities.KIND_METADATA_KIND)
        def kindEntities = datastore.prepare(query).asIterable()

        def endpoints = []
        kindEntities.each {
            String endpoint = it.key.name
            if(! endpoint.startsWith("__"))
                endpoints << endpoint
        }
        return endpoints
    }

}
