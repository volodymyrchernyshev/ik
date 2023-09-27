package org.ik.dynamic.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfPathsInAMatrix {

    @Test
    public void test(){

        System.out.println(number_of_paths(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 1, 1, 1)),
                new ArrayList<>(Arrays.asList(1, 1, 1, 1)),
                new ArrayList<>(Arrays.asList(1, 1, 1, 1))
        ))));

    }


    static Integer number_of_paths(ArrayList<ArrayList<Integer>> matrix) {
        // Write your code here.
        ArrayList<Integer> firstRow = matrix.get(0);
        int previous = firstRow.get(0);
        for(int i = 0; i < matrix.size(); i++){
            if(previous == 0){
                matrix.get(i).set(i, 0);
            }
            previous = matrix.get(i).get(0);
        }

        previous = matrix.get(0).get(0);

        for(int i = 0; i < firstRow.size(); i++){
            if(previous == 0){
                firstRow.set(i, 0);
            }
            previous = firstRow.get(i);
        }

        final int mod = 1000000007;

        for(int i = 1; i < matrix.size(); i++){
            ArrayList<Integer> previousRow = matrix.get(i-1);
            ArrayList<Integer> currentRow = matrix.get(i);
            for(int j = 1; j < currentRow.size(); j++){
                if(currentRow.get(j).equals(0)){
                    continue;
                }
                int left = currentRow.get(j-1);
                int top = previousRow.get(j);
                currentRow.set(j, (left + top) % mod);
            }

        }

        int n = matrix.size() - 1;
        int m = matrix.get(0).size() - 1;
        return matrix.get(n).get(m);
    }


}
