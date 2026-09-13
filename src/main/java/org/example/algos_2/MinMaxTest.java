package org.example.algos_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MinMaxTest {
    @Test public void mainTest() {
        List<Integer> lst = List.of(1, 2, 3, 4, 5);
        Result res = Solution.findMinMaxCompact(lst);
        Assertions.assertEquals(1, res.min());
        Assertions.assertEquals(5, res.max());
    }
}