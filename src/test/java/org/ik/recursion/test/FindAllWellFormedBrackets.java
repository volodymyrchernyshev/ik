package org.ik.recursion.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FindAllWellFormedBrackets {

    @Test
    public void test() {
        System.out.println(find_all_well_formed_brackets(3));
        System.out.println(find_all_well_formed_brackets(4));
    }


    static ArrayList<String> find_all_well_formed_brackets(Integer n) {
        // Write your code here.
        ArrayList<String> ret = new ArrayList<>();
        find_all_well_formed_brackets(ret, new StringBuilder(), new StringBuilder(), n);
        return ret;
    }

    private static void find_all_well_formed_brackets(ArrayList<String> ret, StringBuilder slateL, StringBuilder slateR, int n) {
        //base case
        if (n == 0) {
            ret.add(slateL.toString() + slateR.toString());
            return;
        }


        //( recursiveCall )
        slateL.append("(");
        slateR.append(")");
        find_all_well_formed_brackets(ret, slateL, slateR, n - 1);
        slateL.delete(slateL.length() - 1, slateL.length());
        slateR.delete(slateR.length() - 1, slateR.length());

        if (n > 1) {
            //we can put 1: () and recursive call or we can put 2: ( recursiveCall );
            slateL.append("()");
            find_all_well_formed_brackets(ret, slateL, slateR, n - 1);
            slateL.delete(slateL.length() - 2, slateL.length());

            //we can close existing sequence and start new
            if(slateR.length() != 0) {
                slateL.append("()").append(slateR);
                find_all_well_formed_brackets(ret, slateL, new StringBuilder(), n - 1);
                slateL.delete(slateL.length() - 2 - slateR.length(), slateL.length());

                //we can close existing sequence and start new
                if(slateR.length() != 0) {

                    for(int i = slateR.length(); i > 0; i-- ){
                        String slateRsubString = slateR.substring(0, i);
                        slateL.append("()").append(slateRsubString);
                        StringBuilder newSlateR = new StringBuilder(slateR.substring(i , slateR.length()));
                        find_all_well_formed_brackets(ret, slateL, newSlateR, n - 1);
                        slateL.delete(slateL.length() - 2 - slateRsubString.length(), slateL.length());
                    }

                }

            }
        }

    }

    @Test
    public void test2() {
        System.out.println(find_all_well_formed_brackets2(3));
        System.out.println(find_all_well_formed_brackets2(4));
    }


    static ArrayList<String> find_all_well_formed_brackets2(Integer n) {
        // Write your code here.
        ArrayList<String> results = new ArrayList<String>();
        StringBuilder slate = new StringBuilder();
        find_all_well_formed_brackets(n,slate,0,0,results);
        return results;
    }
    static void find_all_well_formed_brackets(Integer n,StringBuilder slate,int left,int right,
                       ArrayList<String> results){
        if(right > left || left > n || right>n){
            return;
        }

        if(left == n && right == n){
            results.add(slate.toString());
            return;
        }


        slate.append("(");
        find_all_well_formed_brackets(n,slate,left+1,right,results);
        slate.delete(left + right, slate.length());
        slate.append(")");
        find_all_well_formed_brackets(n,slate,left,right+1,results);
        slate.delete(left + right, slate.length());
    }

}
