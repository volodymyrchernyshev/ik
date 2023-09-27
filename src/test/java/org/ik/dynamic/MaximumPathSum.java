package org.ik.dynamic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumPathSum {


    @Test
    public void test(){

        System.out.println(maximum_path_sum(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(4,5,8)),
                new ArrayList<>(Arrays.asList(3,6,4)),
                new ArrayList<>(Arrays.asList(2,4,7))
        ))));
    }

    static Integer maximum_path_sum(ArrayList<ArrayList<Integer>> grid) {

        if(grid == null || grid.isEmpty()){
            return 0;
        }

        int[][] tab = new int[grid.size()][grid.get(0).size()];

        tab[0][0] = grid.get(0).get(0);

        for(int i = 1; i < tab[0].length; i++){
            tab[0][i] = tab[0][i-1] + grid.get(0).get(i);
        }

        for(int i = 1; i < tab.length; i++){
            tab[i][0] = tab[i-1][0] + grid.get(i).get(0);
        }

        for(int i = 1; i < tab.length; i++){
            for(int j = 1; j < tab[0].length; j++){
                tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]) + grid.get(i).get(j);
            }
        }
        return tab[tab.length-1][tab[0].length-1];
    }


}
