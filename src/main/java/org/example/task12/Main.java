package org.example.task12;


import java.util.*;

// Конвертер строки в объект нужного типа
interface Converter<T> {
    T convert(String value);
}

// Класс базы данных
class Db {
    private final List<String> records;
    private final Map<Class<?>, Converter<?>> converters = new HashMap<>();

    public Db(List<String> records) {
        this.records = new ArrayList<>(records);

        register(String.class, value -> value);
        register(Integer.class, Integer::valueOf);
        register(int.class, Integer::parseInt);
    }

    // Регистрация конвертера для любого типа
    public <T> void register(Class<T> type, Converter<T> converter) {
        converters.put(type, converter);
    }

    // Получение записи по индексу и преобразование в указанный тип
    public <T> T get(int index, Class<T> type) {
        if (index < 0 || index >= records.size()) {
            throw new IndexOutOfBoundsException(
                    "Нет записи с индексом " + index
            );
        }

        String value = records.get(index);

        Converter<?> converter = converters.get(type);

        if (converter == null) {
            throw new IllegalArgumentException(
                    "Конвертер для типа " + type.getName()
                            + " не зарегистрирован"
            );
        }

        Object result = converter.convert(value);
        return type.cast(result);
    }
}

// Первый пользовательский тип
class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

// Второй пользовательский тип
class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        Db db = new Db(List.of(
                "42",
                "10,20",
                "Ivan,25"
        ));

        db.register(Point.class, value -> {
            String[] parts = value.split(",");
            return new Point(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1])
            );
        });

        db.register(Person.class, value -> {
            String[] parts = value.split(",");
            return new Person(
                    parts[0],
                    Integer.parseInt(parts[1])
            );
        });

        System.out.println(db.get(0, String.class));
        System.out.println(db.get(0, Integer.class));
        System.out.println(db.get(1, Point.class));
        System.out.println(db.get(2, Person.class));
    }
}

