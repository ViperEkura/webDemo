package com.elm.utils;


import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.lang.reflect.Type;

public class JsonUtil {
    private static final Gson gson = new Gson();
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }
    public static <T> T fromJson(BufferedReader reader, Class<T> clazz)
            throws JsonSyntaxException, JsonIOException {
        return gson.fromJson(reader, clazz);
    }
    public static <T> T fromJson(BufferedReader reader, Type type)
            throws JsonSyntaxException, JsonIOException {
        return gson.fromJson(reader, type);
    }
}
