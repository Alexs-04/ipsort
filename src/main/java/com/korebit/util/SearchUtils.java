package com.korebit.util;

import com.korebit.exception.NetworkNotFunException;
import com.korebit.model.Data;
import com.korebit.model.Network;

public final class SearchUtils {

    public static String currentSearch;

    private SearchUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static Network selectRandomSearch(int identifier) {
        if (!SortUtils.comprobateSortByIdentifier) {
            currentSearch = "Lineal";
            return linealSearch(identifier);
        }

        int random = Const.RANDOM.nextInt(2) + 1;

        if (random == 1) {
            currentSearch = "Binaria";
            return binarySearch(identifier);
        } else {
            currentSearch = "Lineal";
            return linealSearch(identifier);
        }
    }

    private static Network linealSearch(int identifier) {
        for (var network : Data.getNetworks()) {
            if (network.getIdentifier() == identifier) {
                return network;
            }
        }
        throw new NetworkNotFunException("Network with Identifier " + identifier + " not found");
    }

    private static Network binarySearch(int identifier) {
        int left = 0;
        int right = Data.getNetworks().size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Network midNetwork = Data.getNetworks().get(mid);

            if (midNetwork.getIdentifier() == identifier) {
                return midNetwork;
            } else if (midNetwork.getIdentifier() < identifier) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        throw new NetworkNotFunException("Network with Identifier " + identifier + " not found");
    }

    public static Network linealSearchByName(String name) {
        for (var network : Data.getNetworks()) {
            if (network.getName().equalsIgnoreCase(name)) {
                return network;
            }
        }
        throw new NetworkNotFunException("Network with name " + name + " not found");
    }
}
