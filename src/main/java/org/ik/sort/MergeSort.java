package org.ik.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {


    public List<Integer> sort(List<Integer> arr) {
        sort(arr, 0, arr.size() - 1);
        return arr;
    }


    public void sort(List<Integer> arr, int start, int end) {
        if (start >= end) {
            return;
        }
        //start is our offset
        int mid = (end - start) / 2 + start;

        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        int j = start;
        int k = mid + 1;
        List<Integer> buffer = new ArrayList<>();
        while (j <= mid && k <= end) {
            if (arr.get(j) <= arr.get(k)) {
                buffer.add(arr.get(j));
                j++;
            } else {
                buffer.add(arr.get(k));
                k++;
            }
        }
        while (j <= mid) {
            buffer.add(arr.get(j));
            j++;
        }
        while (k <= end) {
            buffer.add(arr.get(k));
            k++;
        }

        for (int i = 0; i < buffer.size(); i++) {
            arr.set(start + i, buffer.get(i));
        }
    }
}
