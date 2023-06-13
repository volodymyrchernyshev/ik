package org.ik.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TowerOfHanoi {

    @Test
    public void test(){
        System.out.println(tower_of_hanoi(3));
    }

    static ArrayList<ArrayList<Integer>> tower_of_hanoi(Integer n) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        tower_of_hanoi_util(n, 1,  2, 3, answer);
        return answer;
    }

    private static void tower_of_hanoi_util(Integer n, int source, int aux, int destination, ArrayList<ArrayList<Integer>> ret) {

        ArrayList<Integer> step = new ArrayList<>();
        step.add(source);
        step.add(destination);

        if(n == 1){
            ret.add(step);
            return;
        }
        tower_of_hanoi_util(n-1, source, destination, aux, ret);
        ret.add(step);
        tower_of_hanoi_util(n-1, aux, source, destination, ret);
    }

}
