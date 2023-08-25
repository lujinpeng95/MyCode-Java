/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package core.util.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class GsonJsonObjectAdapter implements JsonSerializer<JsonObject>, JsonDeserializer<JsonObject> {

    @Override
    public JsonObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        if (json == null || !json.isJsonObject()) {
            return null;
        }
        return json.getAsJsonObject();
    }

    @Override
    public JsonElement serialize(JsonObject src, Type typeOfSrc, JsonSerializationContext context) {
        return src;
    }
}
