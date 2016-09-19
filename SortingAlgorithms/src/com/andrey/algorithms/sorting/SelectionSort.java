package com.andrey.algorithms.sorting;

/**
 * Selection Sort Algorithm
 *
 * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">https://en.wikipedia.org/wiki/Selection_sort</a>
 * @see <a href="https://rosettacode.org/wiki/Sorting_algorithms/Selection_sort#Java">https://rosettacode.org/wiki/Sorting_algorithms/Selection_sort#Java</a>
 * <p/>
 * Created by andrey on 18/09/16.
 */
public class SelectionSort {

    public <E extends Comparable<? super E>> void selectionSort(E[] arr, E maxValue) {
        for (int currentPlace = 0; currentPlace < arr.length - 1; currentPlace++) {
            E smallest = maxValue;
            int smallestAt = currentPlace + 1;
            for (int check = currentPlace; check < arr.length; check++) {
                if (arr[check].compareTo(smallest) < 0) {
                    smallestAt = check;
                    smallest = arr[check];
                }
            }

            swap(arr, currentPlace, smallestAt);
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

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(elements, Integer.MAX_VALUE);
        for (Integer element : elements) {
            System.out.print(element + " ");
        }

    }
}
