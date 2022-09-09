package com.datacampus.biohealth2.serializer;

import com.datacampus.biohealth2.dto.PerDayNutritionDto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PerNutritionDtoSerializer extends JsonSerializer<PerDayNutritionDto> {

    @Override
    public void serialize(PerDayNutritionDto perDayNutritionDto, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("kcal");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getKcal()));

        jsonGenerator.writeFieldName("protein");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getProtein()));

        jsonGenerator.writeFieldName("Sugar");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getSugar()));

        jsonGenerator.writeFieldName("Sodium");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getSodium()));

        jsonGenerator.writeFieldName("Saturated_fat");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getSaturatedFat()));

        jsonGenerator.writeFieldName("Caffeine");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getCaffeine()));

        jsonGenerator.writeFieldName("drink_kcal");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getDrink_kcal()));

        jsonGenerator.writeFieldName("drink_protein");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getDrink_protein()));

        jsonGenerator.writeFieldName("drink_sugar");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getDrink_sugar()));

        jsonGenerator.writeFieldName("drink_Sodium");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getDrink_Sodium()));

        jsonGenerator.writeFieldName("drink_Caffeine");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getDrink_caffeine()));

        jsonGenerator.writeFieldName("drink_saturated_fat");
        jsonGenerator.writeString(String.valueOf(perDayNutritionDto.getDrink_saturatedFat()));

        jsonGenerator.writeEndObject();
    }

}
