package org.example.task11;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(List.of(3, 4, 5));

        AddListInvocationHandler handler =
                new AddListInvocationHandler(lst);

        lst = (List<Integer>) Proxy.newProxyInstance(
                lst.getClass().getClassLoader(),
                lst.getClass().getInterfaces(),
                handler
        );

        Magic.test(lst);

        System.out.println(handler.count);
    }
}