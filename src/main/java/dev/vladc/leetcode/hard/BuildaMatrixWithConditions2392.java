package dev.vladc.leetcode.hard;

import org.junit.Test;

import java.util.*;

public class BuildaMatrixWithConditions2392 {


    @Test
    public void test()throws Exception{
        int[][] matrix = buildMatrix(3, new int[][]{{1,2},{3,2}}, new int[][]{{2,1},{3,2}});

        for(int i =0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }


    }


    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        int[][] ret = new int[k][k];

        List<Integer> rows = travel(rowConditions, k);
        System.out.println("rows " + rows);
        List<Integer> cols = travel(colConditions, k);
        System.out.println("col "+ cols);

        mainCycle:
        for(int i = 0; i < k; i++){
            int row = rows.get(i);
            for(int j = 0; j < k; j++){
                int column = cols.get(j);
                if(row == column){
                    ret[i][j] = row;
                    continue mainCycle;
                }
            }
        }

        return ret;
    }

    private List<Integer> travel(int[][] cond, int k) {
        ArrayList<Integer>[] aList = new ArrayList[k];
        int[] count = new int[k];

        for(int i = 0; i < k ; i++){
            aList[i] = new ArrayList<>();
        }

        for(int[] c : cond){

            int after = c[0];
            int before = c[1];

            aList[before-1].add(after);
            count[after-1]++;
        }


        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < k; i++){
            if(count[i] == 0){
                q.add(i+1);
            }
        }

        List<Integer> ret = new ArrayList<>();

        while(!q.isEmpty()){
            Integer v = q.poll();
            ret.add(v);
            ArrayList<Integer> next = aList[v - 1];
            for (Integer n : next) {
                count[n - 1]--;
                if (count[n - 1] == 0) {
                    q.add(n);
                }
            }
        }

        Collections.reverse(ret);

        return ret;
    }


}
