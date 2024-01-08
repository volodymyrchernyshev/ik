package org.leetcode.q75.binarysearch;

public class KokoEatingBananas {

    /**
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
     * The guards have gone and will come back in h hours.
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas
     * and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead
     * and will not eat any more bananas during this hour.
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     */

    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length > h) {
            return -1;
        }
        int max = Integer.MIN_VALUE, min = 1;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        if (piles.length == h) {
            return max;
        }

        while (min < max) {
            int mid = (max + min) / 2;
            int score = 0;
            for (int pile : piles) {
                score += Math.ceil((double) pile / mid);
            }

            if (score > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return max;
    }

}
