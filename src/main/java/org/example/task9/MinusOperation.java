package org.example.task9;

import java.util.function.BinaryOperator;

public class MinusOperation implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer x, Integer y) {
        return x - y;
    }
}
