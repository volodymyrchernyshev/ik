package org.ik.sort;

import java.util.List;

public class HeapSort {


    public List<Integer> sort(List<Integer> in) {
        int n = in.size();
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(in, n, i);
        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            swap(in, 0, i);
            // call max heapify on the reduced heap
            heapify(in, i, 0);
        }
        return in;
    }

    private void heapify(List<Integer> in, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && in.get(left) > in.get(largest))
            largest = left;

        // If right child is larger than largest so far
        if (right < n && in.get(right) > in.get(largest))
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = in.get(i);
            in.set(i, in.get(largest));
            in.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(in, n, largest);
        }
    }

    private void swap(List<Integer> arr, int a, int b){
        int value = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, value);
    }
}
