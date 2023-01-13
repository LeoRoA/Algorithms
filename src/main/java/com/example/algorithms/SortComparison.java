package com.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class SortComparison {

    public static void main(String[] args) {
        int[] array = generateRandomArray();

        int[] array1 = Arrays.copyOf(array, array.length);
        System.out.println("array1:");
        for (int i = 0; i < 20; i++) {
            System.out.print(array1[i] + " ");
        }
        benchmarkSort(array1, SortComparison::sortBubble);
        System.out.println("Sorted array1:");
        for (int i = 0; i < 20; i++) {
            System.out.print(array1[i] + " ");
        }

        int[] array2 =  Arrays.copyOf(array, array.length);
        System.out.println("\n_____________________");
        System.out.println("\narray2:");
        for (int i = 0; i < 20; i++) {
            System.out.print(array2[i] + " ");
        }
        benchmarkSort(array2, SortComparison::sortInsertion);
        System.out.println("Sorted array2:");
        for (int i = 0; i < 20; i++) {
            System.out.print(array2[i] + " ");
        }

        int[] array3 =  Arrays.copyOf(array, array.length);
        System.out.println("\n_____________________");
        System.out.println("\narray3:");
        for (int i = 0; i < 20; i++) {
            System.out.print(array3[i] + " ");
        }
        benchmarkSort(array3, SortComparison::sortSelection);
        System.out.println("Sorted array3:");
        for (int i = 0; i < 20; i++) {
            System.out.print(array3[i] + " ");
        }
    }

    private static void benchmarkSort(int[] array, Consumer<int[]> sortFunction) {

        long start = System.currentTimeMillis();
        sortFunction.accept(array);
        long end = System.currentTimeMillis();
        System.out.println("\nArray is sorted? - " + isSorted(array));
        System.out.println("Execution time: " + (end - start) + " ms ");
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


    private static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }

    }


    private static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static int[] generateRandomArray() {
        return IntStream
                .generate(() -> ThreadLocalRandom.current().nextInt(0, 100_000))
                .limit(100_000)
                .toArray();
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;

    }
}

