package com.andrey.algorithms.sorting;

/**
 * Shell Sort Algorithm
 *
 * @see <a href="https://en.wikipedia.org/wiki/Shellsort">https://en.wikipedia.org/wiki/Shellsort</a>
 * @see <a href="https://rosettacode.org/wiki/Sorting_algorithms/Shell_sort#Java">https://rosettacode.org/wiki/Sorting_algorithms/Shell_sort#Java</a>
 * <p/>
 * Created by andrey on 18/09/16.
 */
public class ShellSort {

    public <E extends Comparable<? super E>> void shellSort(E[] arr) {
        int increment = arr.length / 2;
        while (increment > 0) {
            for (int i = increment; i < arr.length; i++) {
                int j = i;
                E temp = arr[i];
                while (j >= increment && arr[j - increment].compareTo(temp) > 0) {
                    arr[j] = arr[j - increment];
                    j = j - increment;
                }
                arr[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] elements = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(elements);
        for (Integer element : elements) {
            System.out.print(element + " ");
        }
    }
}
