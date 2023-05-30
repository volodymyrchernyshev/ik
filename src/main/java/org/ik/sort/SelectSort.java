package org.ik.sort;

import java.util.List;

public class SelectSort {

    public List<Integer> sort(List<Integer> arr){
        for(int i = 0; i < arr.size(); i++){
            int min = findMin(arr, i);
            swap(arr, i, min);
        }
        return arr;
    }

    private int findMin(List<Integer> arr, int start) {
        int min = start;
        int value = arr.get(start);
        for(int i = start + 1; i < arr.size(); i++){
            int current = arr.get(i);
            if(current < value){
                value = current;
                min = i;
            }
        }
        return min;
    }

    private void swap(List<Integer> arr, int indexA, int indexB){
        int value = arr.get(indexA);
        arr.set(indexA, arr.get(indexB));
        arr.set(indexB, value);
    }
}
