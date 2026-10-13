package org.example.task11;

import java.util.List;
import java.util.Random;

public class Magic {
    public Magic() {}

    public static void test(List<Integer> lst) {
        Random random = new Random();
        int addNum = random.nextInt(10);
        int delNum = random.nextInt(addNum);

        for(int i = 0; i < addNum; ++i) {
            lst.addFirst(1);
        }

        for(int i = 0; i < delNum; ++i) {
            lst.removeFirst();
        }

    }
}