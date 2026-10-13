package org.example.task11;

import java.util.ArrayList;
import java.util.List;

class CountableList extends ArrayList<Integer> {

    private int addCount = 0;

    @Override
    public void addFirst(Integer element) {
        addCount++;
        super.addFirst(element);
    }

    public int getAddCount() {
        return addCount;
    }
}

public class Main {
    public static void main(String[] args) {
        CountableList lst = new CountableList();

        lst.addAll(List.of(3, 4, 5));

        Magic.test(lst);

        System.out.println("Количество вызовов addFirst: "
                + lst.getAddCount());
    }
}