package org.ik;

import org.junit.jupiter.api.Test;
import org.springframework.boot.security.reactive.ApplicationContextServerWebExchangeMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ModToBinary {


    @Test
    public void test(){
        System.out.println(intToBinary(1000000007));
    }

    public static String intToBinary(int value){
        StringBuilder sb = new StringBuilder();

        while(value > 0){
            if(value%2 == 1){
                sb.append("1");
            } else {
                sb.append("0");
            }
            value = value/2;
        }
        return sb.reverse().toString();
    }


//    public static void main(String[] args) {
//        getProductSuggestions(new ArrayList<>(), "abc");
//    }

    public static List<List<String>> getProductSuggestions(List<String> products, String search) {
        // Write your code here
        List<List<String>> ret = new ArrayList<>();

        for(int i = 1; i <= search.length(); i++){
            String word = search.substring(0, i);
            ret.add(products.stream().filter(w-> w.startsWith(word)).sorted().limit(3).collect(Collectors.toList()));
        }

        return ret;
    }


    public static void main(String[] args) {


        int ret1 = 0;
        for(int i = 1; i <=3; i++ ){
            ret1 +=i;
        }
        System.out.println(ret1);

//        distributeRanges(Arrays.asList(
//                Arrays.asList(4),
//
//                Arrays.asList(2),
//
//                Arrays.asList(1, 3),
//
//                Arrays.asList(2, 5),
//
//                Arrays.asList(4, 8),
//
//                Arrays.asList(10, 20)
//
//        ));
    }


    public static int distributeRanges(List<List<Integer>> ranges) {
        // Write your code here
        List<List<List<Integer>>> groups = new ArrayList<>();

        Collections.sort(ranges, (o1,o2) -> Integer.compare(o1.get(0), o2.get(0)));

        groups.add(new ArrayList<>(Arrays.asList(ranges.get(0))));
        main:
        for(int i = 1; i < ranges.size(); i++){

            List<Integer> range = ranges.get(i);

            for (int j =0; j < groups.size(); j++) {
                List<List<Integer>> group = groups.get(j);
                if(isOverlapping(range, group)){
                    group.add(range);
                    continue main;
                }
            }
            groups.add(new ArrayList<>(Arrays.asList(range)));
        }

        int groupSize = groups.size();
        if(groupSize == 1){
            return 0;
        } else if(groupSize == 2){
            return 2;
        } else if(groupSize == 3){
            return 6;
        } else {
            int ret = 0;
            for(int i = 1; i <=groupSize; i++ ){
                ret +=i;
            }
            return ret;
        }
    }


    private static boolean isOverlapping(List<Integer> range1, List<List<Integer>> group) {

        for (List<Integer> range2 : group) {
            if(range1.size() == 1){
                if(range2.size() ==1){
                    if(range1.get(0).equals(range2.get(0))){
                        return true;
                    }
                }else{
                    int range1Start = range1.get(0);
                    int range2Start = range2.get(0);
                    int range2End = range2.get(1);
                    if(range1Start == range2Start || range1Start == range2End){
                        return true;
                    } else if(range1Start > range2Start && range1Start < range2End){
                        return true;
                    }
                }
            } else {
                if(range2.size() ==1){
                    int range1Start = range1.get(0);
                    int range1End = range1.get(1);
                    int range2Start = range2.get(0);
                    if(range2Start == range1Start || range2Start == range1End){
                        return true;
                    } else if(range2Start > range1Start && range2Start < range1End){
                        return true;
                    }
                } else {

                    int range1Start = range1.get(0);
                    int range1End = range1.get(1);
                    int range2Start = range2.get(0);
                    int range2End = range2.get(1);

                    if (range1Start == range2Start || range1Start == range2End || range1End == range2Start ||
                            range1End == range2End) {
                        return true;
                    }

                    if (range1Start > range2Start && range1Start < range2End) {
                        return true;
                    }

                    if (range1End > range2Start && range1End < range2End) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
