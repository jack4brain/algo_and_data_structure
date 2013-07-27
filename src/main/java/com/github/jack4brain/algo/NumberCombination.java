package com.github.jack4brain.algo;

/**
 * NumberCombination class prints numbers combination.
 * <p/>
 * <p>For example:</p>
 * <p>number = 4</p>
 * <p>rate = 2</p>
 * <p>Result will be next</p>
 * <ul>
 * <li>2 2</li>
 * <li>2 1 1</li>
 * <li>2 1 1 1</li>
 * </ul>
 *
 * @author Eugen Pyanov
 */
public class NumberCombination {

    public static void main(String[] args) {
        print(6, 3);
    }

    public static void print(int number, int rate) {
        printRecursively(number, rate, new StringBuilder());
    }

    private static void printRecursively(int number, int rate, StringBuilder result) {
        if (number == 0) {
            System.out.println(result.toString());

        } else if (number < rate) {
            printRecursively(number, rate - 1, result);

        } else {
            StringBuilder subResult = new StringBuilder(result);
            subResult.append(" ").append(rate);
            printRecursively(number - rate, rate, subResult);

            if (rate - 1 != 0) {
                printRecursively(number, rate - 1, result);
            }
        }
    }
}
