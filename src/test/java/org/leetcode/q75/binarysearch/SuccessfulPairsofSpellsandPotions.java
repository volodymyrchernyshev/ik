package org.leetcode.q75.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SuccessfulPairsofSpellsandPotions {


    /**
     * You are given two positive integer arrays spells and potions, of length n and m respectively,
     * where spells[i] represents the strength of the ith spell and
     * potions[j] represents the strength of the jth potion.
     * You are also given an integer success. A spell and potion pair is considered successful if the product
     * of their strengths is at least success.
     * Return an integer array pairs of length n where pairs[i] is the number of potions that will
     * form a successful pair with the ith spell.
     */



    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ret = new int[spells.length];

        List<int[]> spellList = new ArrayList<>();
        for(int i = 0; i < spells.length; i++){
            spellList.add(new int[]{spells[i], i});
        }

        Collections.sort(spellList, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        Arrays.sort(potions);

        int j = potions.length - 1;

        for (int[] s : spellList) {

            int value = s[0];
            int i = s[1];


//            while(j >= 0){
//                if((long) value * potions[j] >= success){
//                    j--;
//                } else {
//                    break;
//                }
//            }
            while (j >= 0 && (long) value * potions[j] >= success) {
                j--;
            }

            ret[i] = potions.length -j;
        }
        return ret;
    }

}
