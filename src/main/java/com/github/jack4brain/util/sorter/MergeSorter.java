package com.github.jack4brain.util.sorter;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSorter<T> {

    public static void main(String[] args) {
        MergeSorter<Integer> bubbleSorter = new MergeSorter(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        Integer[] items = {4, 2, 1, 2, 3};

        System.out.println(Arrays.toString(items));

        bubbleSorter.sort(items);

        System.out.println(Arrays.toString(items));
    }


    private Comparator<T> comparator;

    public MergeSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] items) {

    }

    private void swap(T[] items, int left, int right) {
        Object temp = items[left];
        items[left] = items[right];
        items[right] = (T) temp;
    }

    private boolean isNeedToSwap(T o1, T o2) {
        return comparator.compare(o1, o2) < 0;
    }

}
