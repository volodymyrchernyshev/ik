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
            Pivot middle = partition(arr, start, end);
            quickSort(arr, start, middle.left-1);
            quickSort(arr, middle.right + 1, end);
        }
    }

    protected Pivot partition(List<Integer> arr, int start, int end) {
        int pivot = new Random().nextInt((end - start) + 1) + start;
        Collections.swap(arr, start, pivot);

        int pivotLeft = start;
        int pivotValue = arr.get(start);
        int pivotRight = pivotLeft;

        for(int i = start + 1; i <= end; i++){
            int current = arr.get(i);
            if(current == pivotValue){
                pivotRight++;
                swap(arr, i, pivotRight);
            } else if(current > pivotValue){
                //ok, do nothing
            } else {
                if(pivotRight +1 != i ) {
                    swap(arr, pivotLeft, pivotRight + 1);
                }
                swap(arr, i, pivotLeft);
                pivotRight++;
                pivotLeft++;
            }
        }
        return new Pivot(pivotLeft, pivotRight);
    }

    private void swap(List<Integer> arr, int a, int b) {
        int t = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, t);
    }

    static class Pivot{
        int left;
        int right;

        public Pivot(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
