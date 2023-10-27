package org.leetcode.q75.heap;

import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {

    /**
     * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
     *
     * Implement the SmallestInfiniteSet class:
     *
     * SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
     * int popSmallest() Removes and returns the smallest integer contained in the infinite set.
     * void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
     */

    private int smallest = 1;
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public int popSmallest() {
        if(queue.isEmpty()){
            return smallest++;
        }
        return queue.poll();
    }

    public void addBack(int num) {
        if(num >= smallest){
            //do nothing
        } else {
            if(!queue.contains(num)){
                queue.add(num);
            }
        }
    }

}
