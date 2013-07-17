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

        Integer[] items = {2, 5, 3, 2, 1, 1};

        System.out.println(Arrays.toString(items));

        bubbleSorter.sort(items);

        System.out.println(Arrays.toString(items));
    }


    private Comparator<T> comparator;

    public QuickSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] items) {
        qSort(items, 0, items.length - 1);
    }

    private void qSort(T[] items, int low, int high) {
        int i = low;
        int j = high;
        T value = items[(low + high) / 2];  // value - опорный элемент посредине между low и high

        do {

            while (comparator.compare(items[i], value) < 0) {
                ++i;  // поиск элемента для переноса в старшую часть
            }

            while (comparator.compare(items[j], value) > 0) {
                --j;  // поиск элемента для переноса в младшую часть
            }

            if (i <= j) {
                swap(items, i, j);

                // переход к следующим элементам:
                i++;
                j--;
            }

        } while (i < j);

        if (low < j) {
            qSort(items, low, j);
        }

        if (i < high) {
            qSort(items, i, high);
        }
    }

    private void swap(T[] items, int left, int right) {
        Object temp = items[left];
        items[left] = items[right];
        items[right] = (T) temp;
    }
}
