package org.ik.sort.exercise;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SortingClass {

    @Test
    public void test2SumInAnArray(){
        System.out.println(two_sum(new ArrayList<>(Arrays.asList(5, 3, 10, 45, 1)), 6));
    }

    static ArrayList<Integer> two_sum(ArrayList<Integer> numbers, Integer target) {
        ArrayList ret = new ArrayList();

        Map<Integer, Integer> tab = new HashMap<>();

        for (int i =0; i < numbers.size(); i++) {
            Integer v = numbers.get(i);
            Integer existing = tab.put(v, i);
            if(existing != null && target.equals(v + v)){
                ret.add(existing);
                ret.add(i);
                return ret;
            }
        }

        for (int i =0; i < numbers.size(); i++) {
            Integer v = numbers.get(i);
            int other = target - v;
            Integer existing = tab.get(other);
            if(existing != null){
                ret.add(existing);
                ret.add(i);
                return ret;
            }

        }
        ret.add(-1);
        ret.add(-1);

        return ret;
    }


    static class LinkedListNode {
        Integer value;
        LinkedListNode next;

        LinkedListNode(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

    static LinkedListNode merge_k_lists(ArrayList<LinkedListNode> lists) {
        LinkedListNode originalRoot = findMin(lists);
        LinkedListNode root = originalRoot;
        while(!lists.isEmpty()) {
            root.next = findMin(lists);
            root = root.next;
            removeEmptyNodex(lists);
        }

        return originalRoot;
    }

    private static void removeEmptyNodex(ArrayList<LinkedListNode> lists) {
        for(Iterator<LinkedListNode> iterator = lists.iterator(); iterator.hasNext(); ){
            LinkedListNode next = iterator.next();
            if(next == null || next.value == null){
                iterator.remove();
            }

        }
    }

    private static LinkedListNode findMin(ArrayList<LinkedListNode> lists) {
        int nodeIndex = 0;
        LinkedListNode node = lists.get(0);
        for(int i = 1; i < lists.size(); i++){
            LinkedListNode next = lists.get(i);
            if(next.value.compareTo(node.value) < 0){
                node = next;
                nodeIndex = i;
            }
        }
        lists.set(nodeIndex, node.next);
        return node;
    }


}
