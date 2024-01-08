package org.leetcode.amazon;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Test2 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(singleNumber(new int[]{1,2,1,3,2,5})));
    }

    @Test
    public void test2() {
        System.out.println(findFirstSetBit(1));
        System.out.println(findFirstSetBit(2));
        System.out.println(findFirstSetBit(4));
    }

    public int[] singleNumber(int[] nums) {


        if(nums.length == 2){
            return nums;
        }

        int value = 0;

        for(int n : nums){
            value ^= n;
        }



        int fistSetBit = findFirstSetBit(value);


        int a =0;
        int b = 0;

        for(int n : nums){

//            if((n & (1L << fistSetBit)) != 0){
            if(((n >>> fistSetBit) & 1) == 0){
                a ^= n;
            }else {
                b ^= n;
            }

        }

        return new int[]{a,b};

    }

    private int findFirstSetBit(int value) {
        int i = 0;
        for (; ((value >>> i) & 1) == 0; i++) {
        }
        return i;
    }


    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]));
        for(int i = 0; i < matrix.length; i++){
            q.add(new int[]{i, 0});
        }

        int ret = 0;
        for(int i = 0; i < k; i++){
            int[] v = q.poll();
            ret = matrix[v[0]][v[1]];
            if(v[1] < matrix[v[0]].length - 1){
                q.add(new int[]{v[0], v[1] + 1});
            }
        }

        return ret;
    }

    public int countPrimes(int n) {
        BitSet primes = new BitSet(5*1000*1000);
        if (n <= 2) {
            return 0;
        }

        for (int p = 2; p <= (int)Math.sqrt(n); ++p) {
            if (!primes.get(p)) {
                for (int j = p*p; j < n; j += p) {
                    primes.set(j, true);
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!primes.get(i)) {
                count++;
            }
        }


        return count;
    }



    public int characterReplacement(String s, int k) {

        List<int[]> substrings = new ArrayList<>();

        char last = 'a';
        char count = 0;
        for(char c : s.toCharArray()){
            if(last == c){
                count ++;
            } else if(count > 0){
                substrings.add(new int[]{last, count});
                last = c;
                count = 1;
            }
        }

        int ret = 0;

        for(int i = 0; i < substrings.size(); i++){
            int current = substrings.get(i)[1];
            int currentC = substrings.get(i)[0];
            int currentK = k;
            for(int j = i+1; j < substrings.size() && currentK >=0; j++){
                if(substrings.get(j)[0] != currentC) {
                    currentK -= substrings.get(j)[1];
                }
                if(currentK > 0){
                    current += substrings.get(j)[1];;
                }
            }
            ret = Math.max(ret, current);
        }
        return -1;

    }



}
