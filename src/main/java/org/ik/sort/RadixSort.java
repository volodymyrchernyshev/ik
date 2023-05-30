package org.ik.sort;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class RadixSort {


    public List<Integer> sort(List<Integer> arr) {
        int m = Collections.max(arr);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, arr.size(), exp);
        return arr;
    }


    private void countSort(List<Integer> arr, int n, int exp) {
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (Integer i : arr) {
            count[i / exp % 10]++;
        }

        //now count has number of occurrences.
        // let's change the into indexes (starting with 1).
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr.get(i) / exp) % 10] - 1] = arr.get(i);
            count[(arr.get(i) / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr.set(i, output[i]);
    }

}
