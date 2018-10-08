package app.comp.util;

import app.comp.entity.data.Region;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class RegionSerializer extends JsonSerializer<Region> {

    @Override
    public void serialize(Region region, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("id");
        jsonGenerator.writeNumber(region.getId());
        jsonGenerator.writeFieldName("name");
        jsonGenerator.writeString(region.getName());
        jsonGenerator.writeEndObject();
    }
}