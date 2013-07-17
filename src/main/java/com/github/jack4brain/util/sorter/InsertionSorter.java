package com.github.jack4brain.util.sorter;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSorter<T> {

    public static void main(String[] args) {
        InsertionSorter<Integer> bubbleSorter = new InsertionSorter(new Comparator<Integer>() {
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

    public InsertionSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] items) {
        int length = items.length;

        for (int i = 1; i < length; i++) {

            T insertValue = items[i];
            int insertPosition = i;

            while (insertPosition > 0 && isNeedToSwap(insertValue, items[insertPosition - 1])) {
                // shift value
                items[insertPosition] = items[insertPosition - 1];

                insertPosition--;
            }

            items[insertPosition] = insertValue;
        }
    }

    private boolean isNeedToSwap(T o1, T o2) {
        return comparator.compare(o1, o2) < 0;
    }

}
