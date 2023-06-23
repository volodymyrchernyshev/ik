package org.ik.sort.exercise;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {

    @Test
    public void test1(){
//        ArrayList<ArrayList<Integer>> ret = four_sum(new ArrayList<>(Arrays.asList(2, 1, 6, 3, 1, 3, 5, 4, 4, 5, 6, 2)), 11);

        ArrayList<ArrayList<Integer>> ret = four_sum(new ArrayList<>(Arrays.asList(251, 251, 251, 251, 251, 251, 251)), 1004);

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(ret.stream().map(l -> l.toString()).collect(Collectors.toList())));
    }

    static ArrayList<ArrayList<Integer>> four_sum(ArrayList<Integer> arr, Integer target) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for(int i = 0; i< arr.size(); i++){
            if(i == 0 || !arr.get(i).equals(arr.get(i-1))) {
                int first = arr.get(i);
                for(int j = i+1; j < arr.size(); j++) {
                    int second = arr.get(j);
                    if(j == i+1 || !arr.get(j).equals(arr.get(j-1))) {
                        findTwo(arr, j + 1, target, first, second, ret);
                    }
                }
            }
        }
        return ret;
    }



    private static void findTwo(ArrayList<Integer> arr, int i, Integer target, int first, int second, ArrayList<ArrayList<Integer>> ret) {

        for(int l = i, r = arr.size() -1; l < r;){
            int sum = first + second + arr.get(l) + arr.get(r);
            if(sum > target){
                r--;
            } else if(sum < target){
                l++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(first);
                list.add(second);
                list.add(arr.get(l));
                list.add(arr.get(r));
                ret.add(list);
                r--;
                l++;
                while(arr.get(l).equals(arr.get(l -1)) && l < r){
                    l++;
                }
            }
        }

    }


}