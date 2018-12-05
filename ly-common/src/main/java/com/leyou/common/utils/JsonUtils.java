package com.leyou.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: HuYi.Zhang
 * @create: 2018-04-24 17:20
 **/
@Slf4j
public class JsonUtils {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    public static <T> T toBean(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <E> List<E> toList(String json, Class<E> eClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        String name;
        Integer age;
    }
    public static void main(String[] args) {
        User user = new User("Jack", 21);
        // toString
        String json = toString(user);
        System.out.println(json);
        // toBean
        User user1 = toBean(json, User.class);
        System.out.println(user1);
        // toList
        json = "[1, 2, 3, 4]";
        List<Integer> list = toList(json, Integer.class);
        System.out.println(list);
        // toMap
        json = "{\"name\": \"jack\", \"age\": \"21\"}";
        Map<String, String> map = toMap(json, String.class, String.class);
        System.out.println(map);
        // nativeRead
        json = "[{\"name\": \"jack\", \"age\": \"01\"}, {\"name\": \"jack\", \"age\": \"02\"}]";
        List<Map<String, String>> maps = nativeRead(json, new TypeReference<List<Map<String, String>>>() {});
        for (Map<String, String> stringMap : maps) {
            System.out.println(stringMap);
        }
    }
}