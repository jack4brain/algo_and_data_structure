package com.github.jack4brain.util.sorter;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSorter<T> {

    public static void main(String[] args) {
        QuickSorter<Integer> bubbleSorter = new QuickSorter(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        Integer[] items = {5, 6, 3, 12, 4, 10};

        System.out.println(Arrays.toString(items));

        bubbleSorter.sort(items);

        System.out.println(Arrays.toString(items));
    }


    private Comparator<T> comparator;

    public QuickSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] items) {
        quickSort(items, 0, items.length);
    }

    public void quickSort(T[] items, int left, int right) {
        if (left >= right) {
            return;
        }

        int boundary = left;
        T leftValue = items[left];

        for (int i = left + 1; i < right; i++) {
            if (isNeedToSwap(leftValue, items[i])) {
                boundary++;
                swap(items, boundary, i);
            }
        }

        swap(items, left, boundary);
        quickSort(items, left, boundary);
        quickSort(items, boundary + 1, right);
    }

    private boolean isNeedToSwap(T o1, T o2) {
        return comparator.compare(o1, o2) > 0;
    }

    private void swap(T[] items, int left, int right) {
        if(left == right){
            return;
        }

        Object temp = items[left];
        items[left] = items[right];
        items[right] = (T) temp;
    }
}
