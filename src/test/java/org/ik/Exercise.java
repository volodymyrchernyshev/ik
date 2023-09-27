package org.ik;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

public class Exercise {


    @Test
    public void test() throws Exception{

        System.out.println(maximumSubarraySum(new int[]{1,1,1,7,8,9}, 3));

    }


    public long maximumSubarraySum(int[] nums, int k) {

        int i =0; //last start
        int j =0;
        long max = 0L;

        BitSet dups = new BitSet();
        long sum = 0L;

        mainCycle:
        while(true){
            int currentI = i+j;
            if( currentI >= nums.length){
                break;
            }


            int v = nums[currentI];

            if(dups.get(v)){
                for(; i< currentI;){
                    int oldV = nums[i];
                    sum -= oldV;
                    dups.set(oldV, false);
                    j--;
                    i++;
                    if(v == oldV){
                        continue mainCycle;
                    }
                }
            }

            dups.set(v);
            sum += v;
            j++;
            if(j == k){
                max = Math.max(max, sum);
                dups.set(nums[i], false);
                sum -= nums[i];
                j--;
                i++;
            }
        }

        return max;

    }


}
