package com.github.jack4brain.util.sorter;

import java.util.Arrays;
import java.util.Comparator;

public class RecursiveBubbleSorter<T extends Integer> {

    public static void main(String[] args) {
        RecursiveBubbleSorter<Integer> bubbleSorter = new RecursiveBubbleSorter(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        Integer[] items = {1,2,3,5,4};

        System.out.println(Arrays.toString(items));

        bubbleSorter.sort(items);

        System.out.println(Arrays.toString(items));
    }


    private Comparator<T> comparator;

    public RecursiveBubbleSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] items) {
        sortReq(items, items.length - 1, 0);
    }

    public boolean sortReq(T[] items, int top, int current) {
        boolean swapped = false;

        if (top == 1 || current >= top) {
            return swapped;
        }

        if (items[current].intValue() > items[current + 1].intValue()) {
            swap(items, current, current + 1);
            swapped = true;
        }

        swapped = sortReq(items, top, current + 1) || swapped;

        if (swapped && current == 0) {
            return sortReq(items, top - 1, 0);
        }

        return swapped;
    }

    private void swap(T[] items, int left, int right) {
        Object temp = items[left];
        items[left] = items[right];
        items[right] = (T) temp;
    }

}
