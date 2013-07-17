package com.github.jack4brain.util.sorter;

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSorter<T> {

    public static void main(String[] args) {
        BubbleSorter<Integer> bubbleSorter = new BubbleSorter(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        Integer[] items = {4,2, 1, 2, 3};

        System.out.println(Arrays.toString(items));

        bubbleSorter.sort(items);

        System.out.println(Arrays.toString(items));
    }


    private Comparator<T> comparator;

    public BubbleSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] items) {
        boolean swapped;
        int length = items.length - 1;

        do {
            swapped = false;

            for (int i = 0; i < length; i++) {
                swapped = conditionSwap(items, i, i + 1);
            }

            length--;
        } while (swapped);
    }

    private boolean conditionSwap(T[] items, int left, int right) {
        if (isNeedToSwap(items[left], items[right])) {
            swap(items, left, right);
            return true;
        }

        return false;
    }

    private boolean isNeedToSwap(T o1, T o2) {
        return comparator.compare(o1, o2) > 0;
    }

    private void swap(T[] items, int left, int right) {
        Object temp = items[left];
        items[left] = items[right];
        items[right] = (T) temp;
    }


//    public static void main2(String[] args) {
//        Integer[] items = {1, 2, 3};
//
//        System.out.println(Arrays.toString(items));
//
//        sorter(items);
//
//        System.out.println(Arrays.toString(items));
//    }
//
//    static public void sorter(Integer[] items) {
//        boolean swapped;
//        int length = items.length - 1;
//
//        do {
//            swapped = true;
//
//            for (int i = 0; i < length; i++) {
//                if (items[i] > items[i + 1]) {
//                    swap(items, i, i + 1);
//                    swapped = false;
//                }
//            }
//
//            length--;
//        } while (!swapped);
//    }
//
//    private static void swap(Integer[] items, int left, int right) {
//        Integer temp = items[left];
//        items[left] = items[right];
//        items[right] = temp;
//    }

}
