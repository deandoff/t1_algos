package org.example.task9;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private final Map<Class<?>, Object> objects = new HashMap<>();

    public <T> void register(Class<T> type, T object) {
        objects.put(type, object);
    }

    public <T> T get(Class<T> type) {
        return type.cast(objects.get(type));
    }
}