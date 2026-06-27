package com.korebit.util;

import com.korebit.dto.SortResult;
import com.korebit.model.Data;
import com.korebit.model.Network;
import com.korebit.sort.ComparativeSort;
import com.korebit.sort.NoComparativeSort;
import com.korebit.sort.SortFactory;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public final class SortUtils {

    public static boolean comprobateSortByIdentifier = false;

    private SortUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static long calculateTime(Runnable algorithm) {
        long startTime = System.currentTimeMillis();
        algorithm.run();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static NoComparativeSort getNoComparativeSort() {
        return switch ((int) (Math.random() * 4)) {
            case 0 -> (NoComparativeSort) SortFactory.getSort("counting");
            case 1 -> (NoComparativeSort) SortFactory.getSort("radix");
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    private static ComparativeSort getComparativeSort() {
        return switch ((int) (Math.random() * 5)) {
            case 0 -> (ComparativeSort) SortFactory.getSort("bubble");
            case 1 -> (ComparativeSort) SortFactory.getSort("cocktail");
            case 2 -> (ComparativeSort) SortFactory.getSort("selection");
            case 3 -> (ComparativeSort) SortFactory.getSort("insertion");
            case 4 -> (ComparativeSort) SortFactory.getSort("shell");
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    public static SortResult orchestratorSortByIdentifier() {
        boolean flag = (int) (Math.random() * 2) == 0;
        return flag
                ? orchestratorComparativeSort(Comparator.comparingInt(Network::getIdentifier))
                : orchestratorNoComparativeSort(Network::getIdentifier);
    }

    public static SortResult orchestratorComparativeSort(Comparator<Network> comparator) {
        comprobateSortByIdentifier = false;
        ComparativeSort sort = getComparativeSort();
        long timeTaken = calculateTime(
                () -> sort.sort(Data.getNetworks(), comparator)
        );
        return new SortResult(sort.getClass().getName(), timeTaken);
    }

    public static SortResult orchestratorNoComparativeSort(ToIntFunction<Network> keyExtractor) {
        comprobateSortByIdentifier = false;
        NoComparativeSort sort = getNoComparativeSort();
        long timeTaken = calculateTime(
                () -> sort.sort(Data.getNetworks(), keyExtractor)
        );

        return new SortResult(sort.getClass().getName(), timeTaken);
    }
}
