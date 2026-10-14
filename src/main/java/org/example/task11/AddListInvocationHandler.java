package org.example.task11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AddListInvocationHandler implements InvocationHandler {
    private final Object object;
    int count;

    public AddListInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("add")) {
            count++;
        }

        return method.invoke(object, args);
    }
}