package org.ik.exercise;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumSmaller {


    @Test
    public void test(){
        System.out.println(count_triplets(4, new ArrayList<>(Arrays.asList(5, 0, -1, 3, 2))));
        System.out.println(count_triplets(7, new ArrayList<>(Arrays.asList(2, 2, 2, 1))));
    }

    static Integer count_triplets(Integer target, ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        int sum = 0;
        final int n = numbers.size();
        for(int i = 0; i < n; i++){
            Integer firt = numbers.get(i);
            if(firt + firt + firt >= target){
                break;
            };
            for(int j = i+1; j< n; j++) {
                Integer second = numbers.get(j);
                if(firt + second + second>= target){
                    break;
                }
                for(int k = j+1; k< n; k++) {
                    if(firt + second + numbers.get(k) < target){
                        sum++;
                    } else {
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
