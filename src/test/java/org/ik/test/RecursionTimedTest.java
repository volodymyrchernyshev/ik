package org.ik.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionTimedTest {

    @Test
    public void test() {
        System.out.println(check_if_sum_possible(new ArrayList<>(Arrays.asList(2L, 4L, 8L)), 6L));
    }

    static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k) {
        return check_if_sum_possible(arr, k, 0);
    }

    static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k, int start) {

        for (int i = start; i < arr.size(); i++) {
            long rest = k - arr.get(i);
            if (rest == 0) {
                return true;
            } else {
                if (check_if_sum_possible(arr, rest, i + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

}
