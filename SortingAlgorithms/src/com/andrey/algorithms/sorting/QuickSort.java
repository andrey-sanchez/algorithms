package com.andrey.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * QuickSort Algorithm
 *
 * @see <a href="https://rosettacode.org/wiki/Sorting_algorithms/Quicksort#Java">https://rosettacode.org/wiki/Sorting_algorithms/Quicksort#Java</a>
 * @see <a href="https://en.wikipedia.org/wiki/Quicksort">https://en.wikipedia.org/wiki/Quicksort</a>
 * <p/>
 * Created by andrey on 18/09/16.
 */
public class QuickSort {

    public <E extends Comparable<? super E>> List<E> quickSort(List<E> arr) {
        if (!arr.isEmpty()) {
            E pivot = arr.get(0); //This pivot can change to get faster results


            List<E> less = new ArrayList<>();
            List<E> pivotList = new ArrayList<>();
            List<E> more = new ArrayList<>();

            // Partition
            for (E i : arr) {
                if (i.compareTo(pivot) < 0)
                    less.add(i);
                else if (i.compareTo(pivot) > 0)
                    more.add(i);
                else
                    pivotList.add(i);
            }

            // Recursively sort sublists
            less = quickSort(less);
            more = quickSort(more);

            // Concatenate results
            less.addAll(pivotList);
            less.addAll(more);
            return less;
        }
        return arr;
    }

    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));

        QuickSort quickSort = new QuickSort();
        List<Integer> sortedElements = quickSort.quickSort(elements);
        for (Integer element : sortedElements) {
            System.out.print(element + " ");
        }
    }
}
