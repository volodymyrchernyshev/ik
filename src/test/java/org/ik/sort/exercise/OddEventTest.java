package org.ik.sort.exercise;

import org.junit.jupiter.api.Test;

import java.util.*;

public class OddEventTest {

    @Test
    public void test() throws Exception{
        System.out.println(segregate_evens_and_odds(Arrays.asList(1, 2, 3, 4)));
    }

    static List<Integer> segregate_evens_and_odds(List<Integer> numbers) {
        // Write your code here.

        for(int i = 0, j = numbers.size() -1; i < j;){
            if(numbers.get(i) %2 == 0){
                i++;
                continue;
            }
            if(numbers.get(j) %2 != 0){
                j--;
                continue;
            }

            //swap
            Integer value = numbers.get(i);
            numbers.set(i, numbers.get(j));
            numbers.set(j, value);
        }


        return numbers;

    }

    static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {
        Map<Character, Integer> weights = new HashMap<>();
        weights.put('R', 1);
        weights.put('G', 2);
        weights.put('B', 3);

        Collections.sort(balls, (o1, o2) -> weights.get(o1).compareTo(weights.get(o2)));
        return balls;
    }



    @Test
    public void test2() throws Exception{
        System.out.println(merge_one_into_another(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6, 0, 0, 0)));
    }
    static List<Integer> merge_one_into_another(List<Integer> shortList, List<Integer> longList) {
        // Write your code here.

        int j = shortList.size() -1;
        int i =  j;
        int end = longList.size() -1;

        while(j >= 0){
            if(i >= 0 && longList.get(i) > shortList.get(j)){
                longList.set(end, longList.get(i));
                i--;
            } else {
                longList.set(end, shortList.get(j));
                j--;
            }
            end--;
        }

        return longList;
    }


    @Test
    public void test3(){
//        System.out.println(find_zero_sum(new ArrayList<>(Arrays.asList(10, 3, -4, 1, -6, 9))));
//        System.out.println(find_zero_sum(new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0))));
        System.out.println(find_zero_sum(new ArrayList<>(Arrays.asList(-1, -1, 0, 0, 1, 1))));
    }

    static ArrayList<String> find_zero_sum(ArrayList<Integer> arr) {
        // Write your code here.
        ArrayList<String> ret = new ArrayList<>();
        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            if(i==0 || arr.get(i)-arr.get(i-1)!= 0) {
                findTwo(i, arr, ret);
            }
        }
        return ret;
    }

    private static String findTwo(Integer i, ArrayList<Integer> arr, ArrayList<String> ret) {
        int start = i+1;
        int end = arr.size() -1;

        while(start < end){
            int sum = arr.get(i) + arr.get(start) + arr.get(end);
            if(sum > 0){
                end--;
            } else if(sum < 0){
                start++;
            } else {
                ret.add(arr.get(i) + "," + arr.get(start) + "," + arr.get(end));
                start++;
                end--;
                while(start < end && (arr.get(start) - arr.get(start -1)) == 0){
                    start++;
                }
            }
        }
        return null;
    }

}
