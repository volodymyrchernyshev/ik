package org.ik.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort {

    public List<Integer> sort(List<Integer> arr) {

        Integer max = Collections.max(arr);
        Integer min = Collections.min(arr);
        int[] temp = new int[max - min + 1];

        for (Integer i : arr) {
            temp[i - min]++;
        }

        ArrayList ret = new ArrayList();

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                for (int ii = 0; ii < temp[i]; ii++) {
                    ret.add(i + min);
                }
            }
        }
        return ret;
    }
}
