package org.leetcode.q75.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    /**
     * We are given an array asteroids of integers representing asteroids in a row.
     * For each asteroid, the absolute value represents its size, and the sign represents its direction
     * (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
     * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
     * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
     */

    @Test
    public void test(){
        Assertions.assertEquals("[5, 10]", Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            colide(asteroid, stack);
        }
        int[] ret = new int[stack.size()];
        for(int i = ret.length -1; i >= 0; i--){
            ret[i] = stack.pop();
        }
        return ret;
    }

    private static void colide(int asteroid, Stack<Integer> stack) {
        if(asteroid == 0){
            return;
        }
        if(stack.isEmpty()){
            stack.push(asteroid);
            return;
        }

        if(stack.peek() > 0 && asteroid > 0){
            stack.push(asteroid);
        } else if(stack.peek() < 0 && asteroid < 0){
            stack.push(asteroid);
        } else if(stack.peek() < 0 && asteroid > 0){
            stack.push(asteroid);
        }else {
            Integer pop = stack.peek();
            if(Math.abs(pop) > Math.abs(asteroid)){
                //do nothing
            } else if(Math.abs(pop) == Math.abs(asteroid)){
                stack.pop();
            }else {
                stack.pop();
                colide(asteroid, stack);
            }
        }
    }

}
