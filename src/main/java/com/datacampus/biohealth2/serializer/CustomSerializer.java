package com.datacampus.biohealth2.serializer;

import com.datacampus.biohealth2.dto.PerDayNutritionDto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

public class CustomSerializer {


    public static ObjectMapper getCustomObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(PerDayNutritionDto.class,new PerNutritionDtoSerializer());
        objectMapper.registerModule(simpleModule);

        return objectMapper;
    }



}
