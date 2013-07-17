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

        Integer[] items = {4, 3, 2, 1};

        System.out.println(Arrays.toString(items));

        bubbleSorter.sort(items);

        System.out.println(Arrays.toString(items));
    }


    private Comparator<T> comparator;

    public MergeSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] items) {
        T[] tmpArray = (T[]) new Object[items.length];
        mergeSort(items, tmpArray, 0, items.length - 1);
    }

    private void mergeSort(T[] items, T[] temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(items, temp, left, center);
            mergeSort(items, temp, center + 1, right);
            merge(items, temp, left, center + 1, right);
        }
    }


    private void merge(T[] items, T[] temp,
                       int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (comparator.compare(items[leftPos], items[rightPos]) < 0) {
                temp[tmpPos++] = items[leftPos++];
            } else {
                temp[tmpPos++] = items[rightPos++];
            }
        }

        // Copy rest of first half
        while (leftPos <= leftEnd) {
            temp[tmpPos++] = items[leftPos++];
        }

        // Copy rest of right half
        while (rightPos <= rightEnd) {
            temp[tmpPos++] = items[rightPos++];
        }

        // Copy temp array back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            items[rightEnd] = temp[rightEnd];
        }
    }

}
