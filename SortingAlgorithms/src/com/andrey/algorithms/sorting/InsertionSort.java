package com.andrey.algorithms.sorting;

/**
 * Insertion Sort Algorithm
 *
 * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort#Algorithm">https://en.wikipedia.org/wiki/Insertion_sort#Algorithm</a>
 * @see <a href="https://rosettacode.org/wiki/Sorting_algorithms/Insertion_sort#Java">https://rosettacode.org/wiki/Sorting_algorithms/Insertion_sort#Java</a>
 * <p/>
 * Created by andrey on 18/09/16.
 */
public class InsertionSort {

    public <E extends Comparable<? super E>> void insertionSort(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            E value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(value) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        Integer[] elements = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(elements);
        for (Integer element : elements) {
            System.out.print(element + " ");
        }
    }
}
