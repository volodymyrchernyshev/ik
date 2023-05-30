package org.ik.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {


    @Test
    void sort() {
        InsertionSort sort = new InsertionSort();

        assertEquals(sort.sort(Arrays.asList(1,2,3,4,5,6,7,8)), Arrays.asList(1,2,3,4,5,6,7,8));

        assertEquals(sort.sort(Arrays.asList(8,7,6,5,4,3,2,1)), Arrays.asList(1,2,3,4,5,6,7,8));
        assertEquals(sort.sort(Arrays.asList(8,6,7,3,4,5,1,2)), Arrays.asList(1,2,3,4,5,6,7,8));

    }

}