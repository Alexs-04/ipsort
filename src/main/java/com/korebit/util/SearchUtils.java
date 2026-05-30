package com.korebit.util;

import com.korebit.exception.NetworkNotFunException;
import com.korebit.model.Data;
import com.korebit.model.Network;

public final class SearchUtils {

    public static String currentSearch;

    private SearchUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static Network selectRandomSearch(int nat) {
        if (!SortUtils.comprobateSortByNat) {
            currentSearch = "Lineal";
            return linealSearch(nat);
        }

        int random = Const.RANDOM.nextInt(2) + 1;

        if (random == 1) {
            currentSearch = "Binaria";
            return binarySearch(nat);
        } else {
            currentSearch = "Lineal";
            return linealSearch(nat);
        }
    }

    private static Network linealSearch(int nat) {
        for (var network : Data.getNetworks()) {
            if (network.getNat() == nat) {
                return network;
            }
        }
        throw new NetworkNotFunException("Network with NAT " + nat + " not found");
    }

    private static Network binarySearch(int nat) {
        int left = 0;
        int right = Data.getNetworks().size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Network midNetwork = Data.getNetworks().get(mid);

            if (midNetwork.getNat() == nat) {
                return midNetwork;
            } else if (midNetwork.getNat() < nat) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        throw new NetworkNotFunException("Network with NAT " + nat + " not found");
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
