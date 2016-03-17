package com.trevorism.gcloud.dao

import com.google.appengine.api.datastore.Entity
import org.json.JSONObject

/**
 * @author tbrooks
 */
interface DatastoreDAO {

    Entity create(JSONObject data)

    Entity read(long id)
    List<Entity> readAll()

    Entity update(long id, JSONObject data)

    Entity delete(long id)
}
