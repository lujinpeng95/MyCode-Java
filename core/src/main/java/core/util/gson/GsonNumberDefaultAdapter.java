/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package core.util.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public interface GsonNumberDefaultAdapter<T extends Number> extends JsonSerializer<T>,
        JsonDeserializer<T> {
        T returnNull();

        T returnValue(JsonElement json);

        @Override
        default T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            if (json == null || json.isJsonNull()) {
                return returnNull();
            }

            if (json.isJsonPrimitive()) {
                String stringValue = json.getAsString();
                if ("".equals(stringValue) || "null".equals(stringValue)) {
                    return returnNull();
                } else {
                    return returnValue(json);
                }
            } else {
                return returnNull();
            }
        }

        @Override
        default JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
            if (src == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(src);
        }
    }
