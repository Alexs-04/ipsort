package com.korebit.util;

import com.korebit.dto.SortResult;
import com.korebit.model.Data;
import com.korebit.model.Network;
import com.korebit.sort.Sort;
import com.korebit.sort.SortFactory;

import java.util.Comparator;

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

    public static Sort getRandomSort() {
        return switch ((int) (Math.random() * 4)) {
            case 0 -> SortFactory.getSort("bubble");
            case 1 -> SortFactory.getSort("cocktail");
            case 2 -> SortFactory.getSort("counting");
            case 3 -> SortFactory.getSort("insertion");
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    public static SortResult orchestratorSortByIdentifier() {
        Sort sort = getRandomSort();
        Comparator<Network> comparator = Comparator.comparingInt(Network::getIdentifier);
        comprobateSortByIdentifier = true;

        long timeTaken = calculateTime(
                () -> sort.sort(Data.getNetworks(), comparator)
        );

        return new SortResult(sort.getClass().getName(), timeTaken);
    }

    public static SortResult orchestratorSort(Comparator<Network> comparator) {
        comprobateSortByIdentifier = false;
        Sort sort = getRandomSort();
        long timeTaken = calculateTime(
                () -> sort.sort(Data.getNetworks(), comparator)
        );
        return new SortResult(sort.getClass().getName(), timeTaken);
    }
}
