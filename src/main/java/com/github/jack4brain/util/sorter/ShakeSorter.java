package com.github.jack4brain.util.sorter;

import java.util.Arrays;
import java.util.Comparator;

public class ShakeSorter<T> {

    public static void main(String[] args) {
        ShakeSorter<Integer> bubbleSorter = new ShakeSorter(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        Integer[] items = {7, 4, 2, 1, 2, 3};

        System.out.println(Arrays.toString(items));

        bubbleSorter.sort(items);

        System.out.println(Arrays.toString(items));
    }

    private Comparator<T> comparator;

    public ShakeSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] items) {

        for (int i = 0; i < items.length / 2; i++) {

            boolean swapped = false;
            int end = items.length - i - 1;

            for (int left = i; left < end; left++) {
                swapped = conditionSwap(items, left + 1, left);
            }

            for (int right = end - 1; right > i; right--) {
                swapped = conditionSwap(items, right, right - 1);
            }

            if (!swapped) {
                break;
            }
        }
    }

    private boolean conditionSwap(T[] items, int left, int right) {
        if (isNeedToSwap(items[left], items[right])) {
            swap(items, left, right);
            return true;
        }

        return false;
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
