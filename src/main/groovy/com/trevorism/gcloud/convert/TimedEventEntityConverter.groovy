package com.trevorism.gcloud.convert

import com.google.appengine.api.datastore.Entity
import com.google.appengine.api.datastore.Key
import com.google.appengine.api.datastore.KeyFactory
import com.trevorism.gcloud.model.TimedEvent

/**
 * @author tbrooks
 */
class TimedEventEntityConverter {

    static TimedEvent convert(Entity entity){
        TimedEvent timedEvent = new TimedEvent()
        timedEvent.id = entity.key.id
        timedEvent.name = entity.getProperty("name")
        timedEvent.description = entity.getProperty("description")
        timedEvent.start = entity.getProperty("start")
        timedEvent.end = entity.getProperty("end")

        return timedEvent
    }

    static Entity convert(TimedEvent timedEvent){
        Entity entity
        if(timedEvent.id != 0)
            entity = new Entity("TimedEvent", timedEvent.id)
        else
            entity = new Entity("TimedEvent")

        entity.setIndexedProperty("name", timedEvent.name)
        entity.setUnindexedProperty("description", timedEvent.description)
        entity.setIndexedProperty("start", timedEvent.start)
        entity.setIndexedProperty("end", timedEvent.end)

        return entity
    }

    static Key createKeyForTimedEvent(def id) {
        KeyFactory.createKey("TimedEvent", Long.valueOf(id))
    }

}
