package com.andrey.algorithms.sorting;

/**
 * Bubble Sort Algorithm
 *
 * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">https://en.wikipedia.org/wiki/Bubble_sort</a>
 * @see <a href="https://rosettacode.org/wiki/Sorting_algorithms/Bubble_sort#Java">https://rosettacode.org/wiki/Sorting_algorithms/Bubble_sort#Java</a>
 * <p/>
 * Created by andrey on 18/09/16.
 */
public class BubbleSort {

    public <E extends Comparable<? super E>> void bubbleSort(E[] arr) {
        boolean changed;
        do {
            changed = false;
            for (int a = 0; a < arr.length - 1; a++) {
                if (arr[a].compareTo(arr[a + 1]) > 0) {
                    swap(arr, a, a + 1);
                    changed = true;
                }
            }
        } while (changed);
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

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(elements);
        for (Integer element : elements) {
            System.out.print(element + " ");
        }
    }
}
