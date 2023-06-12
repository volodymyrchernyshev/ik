package org.ik.sort;

import java.util.List;

public class BubbleSort {
    static List<Integer> sort(List<Integer> arr) {
        if(arr.size() <2) return arr;

        for(int i = 0; i < arr.size() - 1; i++){
            //bubble from the end.
            boolean isSwapped = false;
            for(int j = arr.size() - 1; j > i; j--){
                if(arr.get(j) <  arr.get(j -1)){
                    swap(arr, j, j -1);
                    isSwapped = true;
                }
            }
            if(!isSwapped) break;
        }
        return arr;
    }
    static void swap(List<Integer> arr, int a, int b){
        int value = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, value);
    }
}
