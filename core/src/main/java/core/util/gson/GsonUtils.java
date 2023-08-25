/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package core.util.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.CharArrayWriter;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

public class GsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(GsonUtils.class);

    public static final Gson GSON = GsonFactory.createGson();

    public static final Gson GSON_DHE = new GsonBuilder().disableHtmlEscaping().create();

    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        T result = GSON.fromJson(jsonData, type);
        return result;
    }

    public static <T> T parseJsonElementWithGson(JsonElement jsonData, Class<T> type) {
        T result = GSON.fromJson(jsonData, type);
        return result;
    }

    public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
        List<T> result = GSON.fromJson(jsonData, new TypeToken<List<T>>() {
        }.getType());
        return result;
    }


    public static JsonElement getJsonObject(JsonElement object, String... path) {

        if (path == null || path.length == 0) {
            return null;
        }

        for (String p : path) {
            if (object == null) {
                return null;
            }
            if (object instanceof JsonPrimitive) {
                return object;
            } else if (object instanceof JsonObject) {
                object = ((JsonObject) object).get(p);
            }
        }
        return object;
    }

    public static JsonArray getJsonArray(JsonObject object, String... path) {
        if (path == null || path.length == 0) {
            return null;
        }

        for (int i = 0; i < path.length - 1; i++) {
            if (object == null) {
                return null;
            }
            JsonElement jsonElement = object.get(path[i]);
            if (jsonElement == null || !jsonElement.isJsonObject()) {
                return null;
            }
            object = jsonElement.getAsJsonObject();
        }

        if (object == null) {
            return null;
        }
        JsonElement jsonElement = object.get(path[path.length - 1]);
        if (jsonElement == null || !jsonElement.isJsonArray()) {
            return null;
        }
        return jsonElement.getAsJsonArray();
    }

    public static JsonObject toJsonObject(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        JsonObject jsonObject = null;
        try {
            jsonObject = GSON.fromJson(json, JsonObject.class);
        } catch (JsonSyntaxException e) {
            String escapeJson = null;
            try {
                escapeJson = escape(json);
                jsonObject = GSON.fromJson(escapeJson, JsonObject.class);
            } catch (Exception ex) {
                LOGGER.error("toJsonObjectError json[{}], escapeJson[{}]", json, escapeJson, ex);
            }
        } catch (Exception e) {
            LOGGER.error("toJsonObjectError json[{}]", json, e);
        }
        return jsonObject;
    }

    public static JsonArray toJsonArray(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        JsonArray jsonArray = null;
        try {
            jsonArray = GSON.fromJson(json, JsonArray.class);
        } catch (JsonSyntaxException e) {
            String escapeJson = null;
            try {
                escapeJson = escape(json);
                jsonArray = GSON.fromJson(escapeJson, JsonArray.class);
            } catch (Exception ex) {
                LOGGER.error("toJsonArrayError json[{}], escapeJson[{}]", json, escapeJson, ex);
            }
        } catch (Exception e) {
            LOGGER.error("toJsonArrayError json[{}]", json, e);
        }
        if (jsonArray == null) {
            return new JsonArray(0);
        }
        return jsonArray;
    }

    public static <T> T toObject(String json, Class<T> cls) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        T t = null;
        try {
            t = GSON.fromJson(json, cls);
        } catch (JsonSyntaxException e) {
            String escapeJson = null;
            try {
                escapeJson = escape(json);
                t = GSON.fromJson(escapeJson, cls);
            } catch (Exception ex) {
                LOGGER.error("toObjectError json[{}], escapeJson[{}]", json, escapeJson, ex);
            }
        } catch (Exception e) {
            LOGGER.error("toObjectError json[{}]", json, e);
        }
        return t;
    }

    public static <T> T toObject(byte[] json, Class<T> cls) {
        if (json == null || json.length == 0) {
            return null;
        }
        T t = null;
        try {
            t = GSON.fromJson(new String(json), cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T toObject(JsonElement json, Class<T> cls) {
        if (json == null) {
            return null;
        }
        T t = null;
        try {
            t = GSON.fromJson(json, cls);
        } catch (Exception e) {
            LOGGER.error("toObjectError json[{}]", json, e);
        }
        return t;
    }

    /**
     * @param json list的序列化字符串
     * @param <T>  T类型
     * @return List<T>
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        return GSON.fromJson(json, TypeToken.getParameterized(List.class, clazz).getType());
    }

    /**
     * @param json map的序列化结果
     * @param <K>  k类型
     * @param <V>  v类型
     * @return Map<K,V>
     */
    public <K, V> Map<K, V> toMap(String json, Class<K> kClazz, Class<V> vClazz) {
        return GSON.fromJson(json, TypeToken.getParameterized(Map.class, kClazz, vClazz).getType());
    }

    public static String getStringOrDefault(JsonElement object, String defaultValue, String... path) {
        JsonElement jsonObject = getJsonObject(object, path);
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.isJsonPrimitive()) {
            return defaultValue;
        }
        return jsonObject.getAsString();
    }

    public static Integer getIntegerOrDefault(JsonElement object, Integer defaultValue, String... path) {
        JsonElement jsonObject = getJsonObject(object, path);
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.isJsonPrimitive()) {
            return defaultValue;
        }
        Integer result = defaultValue;
        try {
            result = jsonObject.getAsInt();
        } catch (NumberFormatException ex) {
            LOGGER.error("toJsonObjectError json[{}] path[{}]", object, path, ex);
        }
        return result;
    }

    public static Byte getByteOrDefault(JsonElement object, Byte defaultValue, String... path) {
        JsonElement jsonObject = getJsonObject(object, path);
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.isJsonPrimitive()) {
            return defaultValue;
        }
        Byte result = defaultValue;
        try {
            result = jsonObject.getAsByte();
        } catch (NumberFormatException ex) {
            LOGGER.error("toJsonObjectError json[{}] path[{}]", object, path, ex);
        }
        return result;
    }

    public static Long getLongOrDefault(JsonElement object, Long defaultValue, String... path) {
        JsonElement jsonObject = getJsonObject(object, path);
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.isJsonPrimitive()) {
            return defaultValue;
        }
        Long result = defaultValue;
        try {
            result = jsonObject.getAsLong();
        } catch (NumberFormatException ex) {
            LOGGER.error("toJsonObjectError json[{}] path[{}]", object, path, ex);
        }
        return result;
    }

    public static Double getDoubleOrDefault(JsonElement object, Double defaultValue, String... path) {
        JsonElement jsonObject = getJsonObject(object, path);
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.isJsonPrimitive()) {
            return defaultValue;
        }
        Double result = defaultValue;
        try {
            result = jsonObject.getAsDouble();
        } catch (NumberFormatException ex) {
            LOGGER.error("toJsonObjectError json[{}] path[{}]", object, path, ex);
        }
        return result;
    }

    public static JsonElement getJsonElement(JsonObject object, String... path) {
        if (path == null || path.length == 0 || object == null) {
            return null;
        }
        JsonObject tmpJsonObject = object;
        for (int i = 0; i < path.length - 1; i++) {
            if (object == null) {
                return null;
            }
            JsonElement jsonElement = tmpJsonObject.get(path[i]);
            if (jsonElement == null || !jsonElement.isJsonObject()) {
                return null;
            }
            tmpJsonObject = jsonElement.getAsJsonObject();
        }

        if (tmpJsonObject == null) {
            return null;
        }
        return tmpJsonObject.get(path[path.length - 1]);
    }

    public static void removeJsonPropertiesProperties(JsonObject jsonObject, String... property) {
        if (jsonObject == null || property == null || property.length <= 0) {
            return;
        }

        for (String p : property) {
            if (jsonObject.has(p)) {
                jsonObject.remove(p);
            }
        }
    }

    /**
     * 任何对象转string
     *
     * @param object
     *
     * @return
     */
    public static String toJsonString(Object object) {
        if (object == null) {
            return null;
        }
        return GSON.toJson(object);
    }

    public static String escape(String content) {
        if (content == null) {
            return content;
        }
        String result = null;
        try {
            StringReader stringReader = new StringReader(content);
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            int c = -1;
            while ((c = stringReader.read()) != -1) {
                switch (c) {
                    case '\\':
                        charArrayWriter.append("\\\\");
                        break;
                    default:
                        charArrayWriter.append((char) c);
                }
            }
            result = charArrayWriter.toString();
        } catch (Exception ex) {
            LOGGER.error("escape content error. content[{}]", content, ex);
            ex.printStackTrace();
        }
        return result;
    }

    public static byte[] toJsonBytes(Object object) {
        String s = toJsonString(object);
        if (s == null) {
            return null;
        }
        return s.getBytes();
    }

    public static <T extends JsonElement> T toJsonTree(Object t, Class<T> toType) {
        if (t == null) {
            return null;
        }
        if (toType == null) {
            throw new IllegalArgumentException("the param toType is null");
        }
        JsonElement jsonElement = GSON.toJsonTree(t);
        return toType.cast(jsonElement);
    }

    public static boolean isJsonStr(String jsonStr, Class<?> clazz) {
        boolean result;
        try {
            Object jsonObj = GSON.fromJson(jsonStr, clazz);
            result = jsonObj != null;
        } catch (Exception e) {
            LOGGER.warn("GsonUtils isJsonStr Exceptiion", e);
            result = false;
        }
        return result;
    }
}
