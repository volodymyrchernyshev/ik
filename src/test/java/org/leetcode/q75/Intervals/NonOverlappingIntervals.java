package org.leetcode.q75.Intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    /**
     * Given an array of intervals intervals where intervals[i] = [starti, endi],
     * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     */

    @Test
    public void test(){
//        Assertions.assertEquals(1, eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        Assertions.assertEquals(1, eraseOverlapIntervals(new int[][]{{0,2},{1,3},{2,4},{3,5},{4,6}}));
    }



    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        Arrays.sort(intervals, (o1, o2) -> {
            int start = Integer.compare(o1[0], o2[0]);
            if(start != 0){
                return start;
            }
            return Integer.compare(o1[1], o2[1]);
        });
        System.out.println("   ----    ");
        int ret =0;
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }

        for(int i = 1; i < intervals.length; i++){
            int[] current = intervals[i];
            int[] previous = intervals[i - 1];
            if(previous == null){
               continue;
            }
            if(previous[1] > current[0]){
                ret++;
                intervals[i] = null;
            }
        }

        return ret;
    }
}
