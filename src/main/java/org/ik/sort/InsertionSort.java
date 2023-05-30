package org.ik.sort;

import java.util.List;

public class InsertionSort {


    static List<Integer> sort(List<Integer> arr) {
        // Write your code here.
        if (arr.size() < 2) {
            return arr;
        }

        for (int i = 1; i < arr.size(); i++) {
            int value = arr.get(i);
            int previousI = i - 1;
            while (previousI >= 0 && value < arr.get(previousI)) {
                //shift to the left
                arr.set(previousI + 1, arr.get(previousI));
                previousI--;
            }
            arr.set(previousI + 1, value);
        }
        return arr;
    }

}
