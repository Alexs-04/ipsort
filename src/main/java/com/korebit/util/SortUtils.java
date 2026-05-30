package com.korebit.util;

public class SortUtils {

    public static boolean comprobateSortByNat = false;

    private SortUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static long calculateTime() {
        long startTime = System.currentTimeMillis();
        selectRandomSort();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static void selectRandomSort() {

    }
}
