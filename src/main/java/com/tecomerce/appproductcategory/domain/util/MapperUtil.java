package com.tecomerce.appproductcategory.domain.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    public <T> Object mappingEntity(String filterProperties, Class<?> clazz) {
        ObjectMapper mapping = new ObjectMapper();
        try {
            return mapping.readValue(filterProperties, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
