package com.trevorism.gcloud.webapi

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.module.SimpleModule
import com.google.appengine.api.datastore.Entity
import org.json.JSONObject

/**
 * @author tbrooks
 */
class EntityModule extends SimpleModule{

    public EntityModule(){
        addSerializer(Entity.class, new EntitySerializer())
    }

    class EntitySerializer extends JsonSerializer<Entity>{

        @Override
        void serialize(Entity value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
            gen.writeStartObject()
            boolean hasId = false
            value.properties.each { k,v ->
                if(k == "id")
                    hasId = true
                gen.writeFieldName(k)
                gen.writeObject(v)

            }
            if(!hasId)
                gen.writeNumberField("id", value.key.id)
            gen.writeEndObject()
        }

        @Override
        public Class<Entity> handledType()
        {
            return Entity.class;
        }

    }
}
