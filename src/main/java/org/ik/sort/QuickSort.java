package org.ik.sort;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort {

    public List<Integer> sort(List<Integer> arr) {
        quickSort(arr, 0, arr.size() - 1);
        return arr;
    }

    public void quickSort(List<Integer> arr, int start, int end) {

        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private int partition(List<Integer> arr, int start, int end) {


        int randomPivot = new Random().nextInt((end - start) + 1) + start;
        Collections.swap(arr, start, randomPivot);

        int pivotI = start;
        int pivot = arr.get(start);
        start++;

        while (start <= end) {

            if (arr.get(start) < pivot) {
                start++;
            } else if (arr.get(end) > pivot) {
                end--;
            } else {
                swap(arr, start, end);
                start++;
                end--;
            }

        }
        swap(arr, pivotI, end);
        return end;
    }

    private void swap(List<Integer> arr, int a, int b) {
        int t = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, t);
    }
}
