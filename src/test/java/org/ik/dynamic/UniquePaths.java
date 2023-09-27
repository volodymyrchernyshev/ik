package org.ik.dynamic;

import org.junit.jupiter.api.Test;

public class UniquePaths {


    @Test
    public void test(){
        System.out.println(unique_paths(3,2));
    }

    static Integer unique_paths(Integer n, Integer m) {

        int[][] tab = new int[n][m];
        for(int i = 0; i < n; i++){
            tab[i][0] = 1;
        }

        for(int i = 0; i < m; i++){
            tab[0][i] = 1;
        }

        for(int i = 1 ; i < n; i++){
            for(int j = 1 ; j < m; j++){
                tab[i][j] = tab[i - 1][j] + tab[i][j - 1];
            }
        }

        return tab[n-1][m-1];
    }


}
