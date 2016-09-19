package com.andrey.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Merge Sort Algorithm
 *
 * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">https://en.wikipedia.org/wiki/Merge_sort</a>
 * @see <a href="https://rosettacode.org/wiki/Sorting_algorithms/Merge_sort#Java">https://rosettacode.org/wiki/Sorting_algorithms/Merge_sort#Java</a>
 * <p/>
 * Created by andrey on 18/09/16.
 */
public class MergeSort {
    public <E extends Comparable<? super E>> List<E> mergeSort(List<E> m) {
        if (m.size() <= 1) return m;

        int middle = m.size() / 2;
        List<E> left = m.subList(0, middle);
        List<E> right = m.subList(middle, m.size());

        right = mergeSort(right);
        left = mergeSort(left);
        List<E> result = merge(left, right);

        return result;
    }

    private <E extends Comparable<? super E>> List<E> merge(List<E> left, List<E> right) {
        List<E> result = new ArrayList<>();
        Iterator<E> it1 = left.iterator();
        Iterator<E> it2 = right.iterator();

        E x = it1.next();
        E y = it2.next();
        while (true) {
            //change the direction of this comparison to change the direction of the sort
            if (x.compareTo(y) <= 0) {
                result.add(x);
                if (it1.hasNext()) {
                    x = it1.next();
                } else {
                    result.add(y);
                    while (it2.hasNext()) {
                        result.add(it2.next());
                    }
                    break;
                }
            } else {
                result.add(y);
                if (it2.hasNext()) {
                    y = it2.next();
                } else {
                    result.add(x);
                    while (it1.hasNext()) {
                        result.add(it1.next());
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Integer[] elements = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        MergeSort mergeSort = new MergeSort();
        List<Integer> sorted = mergeSort.mergeSort(Arrays.asList(elements));
        for (Integer element : sorted) {
            System.out.print(element + " ");
        }

    }
}
