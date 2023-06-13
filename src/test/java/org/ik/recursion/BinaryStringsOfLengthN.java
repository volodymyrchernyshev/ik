package org.ik.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BinaryStringsOfLengthN {

    @Test
    public void test(){
        System.out.println(get_binary_strings(3));
    }


    static ArrayList<String> get_binary_strings(Integer n) {
        ArrayList<String> ret = new ArrayList<>();
        get_binary_strings(ret, new StringBuilder(), 0, n);
        return ret;
    }

    static void get_binary_strings(ArrayList<String> ret, StringBuilder slate, int index, int n){
        if(index == n){
            ret.add(slate.toString());
            return;
        }
        slate.append("0");
        get_binary_strings(ret, slate, index + 1, n);
        slate.delete(index, index +1);
        slate.append("1");
        get_binary_strings(ret, slate, index + 1, n);
        slate.delete(index, index +1);
    }


}
