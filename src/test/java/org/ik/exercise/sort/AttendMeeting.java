package org.ik.exercise.sort;

import org.junit.jupiter.api.Test;

import java.util.*;

public class AttendMeeting {

    @Test
    public void test(){

    }

    static Integer can_attend_all_meetings(ArrayList<ArrayList<Integer>> intervals) {

        Collections.sort(intervals, (o1, o2)-> {
            return Integer.compare(o1.get(0), o2.get(0));
        });


        for(int i = 1; i < intervals.size(); i++){
            ArrayList<Integer> current = intervals.get(i);
            ArrayList<Integer> previous = intervals.get(i-1);
            if(previous.get(1).compareTo(current.get(0)) < 0){
                return 1;
            }
        }
        return 0;
    }


    @Test
    public void test2(){
        System.out.println(find_top_k_frequent_elements(new ArrayList(Arrays.asList(1, 2, 3, 2, 4, 3, 1)), 2));
    }

    static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {

        Map<Integer, Integer> tab = new HashMap<>();
        for (Integer integer : arr) {
            tab.compute(integer, (key, v) -> v == null ? 1 : v+1);
        }

        Set<Map.Entry<Integer, Integer>> entries = tab.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(entries.size(), (o1,o2) -> o2.getValue().compareTo(o1.getValue()));
        queue.addAll(entries);
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ret.add(queue.poll().getKey());
        }
        return ret;
    }


    @Test
    public void test3(){
        int k = 2;
        ArrayList initial = new ArrayList(Arrays.asList(4, 6));
        ArrayList append = new ArrayList(Arrays.asList(5, 2, 20));
        System.out.println(kth_largest(k, initial, append));
    }

    private static void swap(ArrayList<Integer> arr, int a, int b) {
        Integer aValue = arr.set(a, arr.get(b));
        arr.set(b, aValue);
    }

    static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (Integer v : initial_stream) {
            addToQueue(k, queue, v);
        }
        ArrayList<Integer> ret = new ArrayList<>();

        for (Integer v : append_stream) {
            addToQueue(k, queue, v);
            ret.add(queue.peek());
        }
        return ret;
    }

    private static void addToQueue(Integer k, PriorityQueue<Integer> queue, Integer v) {
        if(queue.size() < k){
            queue.add(v);
        } else {
            if(v > queue.peek()){
                queue.poll();
                queue.add(v);
            }
        }
    }
    private static void swap(int[] arr, int a, int b) {
        int v = arr[a];
        arr[a] = arr[b];
        arr[b] = v;
    }



}
