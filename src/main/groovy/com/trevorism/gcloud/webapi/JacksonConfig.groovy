package com.trevorism.gcloud.webapi

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

import javax.ws.rs.ext.ContextResolver
import javax.ws.rs.ext.Provider

/**
 * @author tbrooks
 */
@Provider
class JacksonConfig implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper

    public JacksonConfig() {
        objectMapper = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper
    }
}