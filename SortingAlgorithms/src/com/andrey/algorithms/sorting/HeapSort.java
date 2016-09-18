package com.andrey.algorithms.sorting;

/**
 * Heap Sort Algorithm
 *
 * @see <a href="https://en.wikipedia.org/wiki/Heapsort">https://en.wikipedia.org/wiki/Heapsort</a>
 * @see <a href="https://rosettacode.org/wiki/Sorting_algorithms/Heapsort#Java">https://rosettacode.org/wiki/Sorting_algorithms/Heapsort#Java</a>
 * <p/>
 * Created by andrey on 18/09/16.
 */
public class HeapSort {

    public <E extends Comparable<? super E>> void heapSort(E[] a) {
        int count = a.length;

        //first place a in max-heap order
        heapify(a, count);

        int end = count - 1;
        while (end > 0) {
            //swap the root(maximum value) of the heap with the
            //last element of the heap
            swap(a, end, 0);
            //put the heap back in max-heap order
            siftDown(a, 0, end - 1);
            //decrement the size of the heap so that the previous
            //max value will stay in its proper place
            end--;
        }
    }

    public <E extends Comparable<? super E>> void heapify(E[] a, int count) {
        //start is assigned the index in a of the last parent node
        int start = (count - 2) / 2; //binary heap

        while (start >= 0) {
            //sift down the node at index start to the proper place
            //such that all nodes below the start index are in heap
            //order
            siftDown(a, start, count - 1);
            start--;
        }
        //after sifting down the root all nodes/elements are in heap order
    }

    public <E extends Comparable<? super E>> void siftDown(E[] a, int start, int end) {
        //end represents the limit of how far down the heap to sift
        int root = start;

        while ((root * 2 + 1) <= end) {      //While the root has at least one child
            int child = root * 2 + 1;           //root*2+1 points to the left child
            //if the child has a sibling and the child's value is less than its sibling's...
            if (child + 1 <= end && a[child].compareTo(a[child + 1]) < 0)
                child = child + 1;           //... then point to the right child instead
            if (a[root].compareTo(a[child]) < 0) {     //out of max-heap order
                swap(a, root, child);
                root = child;                //repeat to continue sifting down the child now
            } else
                return;
        }
    }

    private void swap(Object[] arr, int i1, int i2) {
        if (i1 != i2) {
            Object temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] elements = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(elements);
        for (Integer element : elements) {
            System.out.print(element + " ");
        }
    }
}
