package com.korebit.util;

import com.korebit.model.Alpha;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlphaUtils {
    private static final ArrayList<Alpha> ALPHAS = new ArrayList<>();

    static {
        uploadInitAlphas();
    }

    private AlphaUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    private static void uploadInitAlphas() {
        ALPHAS.add(new Alpha("BubbleSort", 0, 0L));
        ALPHAS.add(new Alpha("InsertionSort", 0, 0L));
        ALPHAS.add(new Alpha("SelectionSort", 0, 0L));
        ALPHAS.add(new Alpha("MergeSort", 0, 0L));
        ALPHAS.add(new Alpha("QuickSort", 0, 0L));
        ALPHAS.add(new Alpha("CocktailSort", 0, 0L));
        ALPHAS.add(new Alpha("CountingSort", 0, 0L));
        ALPHAS.add(new Alpha("RadixSort", 0, 0L));
        ALPHAS.add(new Alpha("ShellSort", 0, 0L));
    }

    public static Alpha getAlpha() {
        return ALPHAS
                .stream()
                .max(Comparator.comparingInt(Alpha::getAppearances))
                .orElse(new Alpha("Non determinate Alfa", 0, 0L));
    }

    public static Long getAlphaTime() {
        return ALPHAS
                .stream()
                .max(Comparator.comparingInt(Alpha::getAppearances))
                .map(Alpha::getBestTime)
                .orElse(0L);
    }

    public static Long getBestTime() {
        return ALPHAS
                .stream()
                .max(Comparator.comparingLong(Alpha::getBestTime))
                .orElse(new Alpha("Non determinate Alfa", 0, 0L)).getBestTime();
    }

    public static List<Alpha> getAlphas() {
        return ALPHAS;
    }

    public static Alpha getAlphaByName(String name) {
        return ALPHAS.stream()
                .filter(alpha -> alpha.getName().equals(name))
                .findFirst()
                .orElse(new Alpha("Non determinate Alfa", 0, 0L));
    }

    public static void updateAlpha(String name, long newTime) {
        Alpha alpha = getAlphaByName(name);
        alpha.updateTime(newTime);
        alpha.setAppearances(alpha.getAppearances() + 1);
    }
}