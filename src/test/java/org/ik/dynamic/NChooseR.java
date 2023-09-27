package org.ik.dynamic;

import org.junit.jupiter.api.Test;

public class NChooseR {

    @Test
    public void test(){
        System.out.println(ncr(5,3));
    }

    static Integer ncr(Integer n, Integer r) {
        // Write your code here.
        if (r > n) {
            return 0;
        }

        if (n == r || r == 0) {
            return 1;
        }

        int[] previousRow = new int[n + 1];

        int[] currentRow = new int[n + 1];
        int[] temp = null;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= r && j <= i; j++) {
                if (i == j || j == 0) {
                    currentRow[j] = 1;
                } else {
                    currentRow[j] = (previousRow[j] + previousRow[j - 1]) % 1000000007;
                }
            }
            temp = previousRow;
            previousRow = currentRow;
            currentRow = temp;
        }
        return previousRow[r];
    }

}
