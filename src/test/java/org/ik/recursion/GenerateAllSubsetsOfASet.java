package org.ik.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GenerateAllSubsetsOfASet {

    @Test
    public void test(){
        System.out.println(generate_all_subsets("xy"
        ));
    }



    static ArrayList<String> generate_all_subsets(String s) {
        ArrayList<String> ret = new ArrayList<>();
        generate_all_subsets(ret, s, new StringBuilder(), 0);
        return ret;
    }

    private static void generate_all_subsets(ArrayList<String> ret, String s, StringBuilder slate, int i) {
        if(i >= s.length()){
            ret.add(slate.toString());
            return;
        }

        //exclude
        generate_all_subsets(ret, s, slate, i+1);
        //include
        slate.append(s.charAt(i));
        generate_all_subsets(ret, s, slate, i+1);
        slate.delete(slate.length() -1, slate.length());//delete last char
    }

}
