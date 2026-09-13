package org.example.algos_2;

import java.util.List;

public class Solution {
    public static Result findMinMaxCompact(List<Integer> list) {

        int min, max, i;

        if (list.size() % 2 == 0) {
            if (list.get(0) < list.get(1)) {
                min = list.get(0);
                max = list.get(1);
            } else {
                min = list.get(1);
                max = list.get(0);
            }
            i = 2;
        } else {
            min = list.get(0);
            max = list.get(0);
            i = 1;
        }

        while (i < list.size() - 1) {
            int first = list.get(i);
            int second = list.get(i + 1);

            if (first < second) {
                if (first < min) min = first;
                if (second > max) max = second;
            } else {
                if (second < min) min = second;
                if (first > max) max = first;
            }

            i = i + 2;
        }
        return new Result(min, max);
    }
}
