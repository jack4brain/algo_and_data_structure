package com.github.jack4brain.util.sorter;

import java.util.Arrays;
import java.util.Comparator;

public class SelectionSorter<T> {

    public static void main(String[] args) {
        SelectionSorter<Integer> bubbleSorter = new SelectionSorter(new Comparator<Integer>() {
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

    public SelectionSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] items) {
        int length = items.length;

        for (int i = 0; i < length; i++) {

            int minPosition = i;

            for (int j = i + 1; j < length; j++) {
                if(isNeedToSwap(items[j], items[minPosition])){
                    minPosition = j;
                }
            }

            if(minPosition != i){
                swap(items, minPosition, i);
            }
        }
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
