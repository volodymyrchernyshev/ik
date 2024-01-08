package org.leetcode.q75.queue;

import java.util.LinkedList;

public class NumberOfRecentCalls {


    /**
     * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
     * Implement the RecentCounter class:
     * RecentCounter() Initializes the counter with zero recent requests.
     * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
     * and returns the number of requests that has happened in the past 3000 milliseconds (including the new request).
     * Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
     * It is guaranteed that every call to ping uses a strictly
     */


    static class RecentCounter {

        private LinkedList<Integer> list;

        public RecentCounter() {
            this.list = new LinkedList<>();
        }

        public int ping(int t) {
            while(!list.isEmpty() && (t > list.getFirst() + 3000)){
                list.removeFirst();
            }
            list.add(t);

            return list.size() - 1;
        }
    }

}
