package com.korebit.sort;

import com.korebit.model.Network;

import java.util.Comparator;
import java.util.List;

public class CocktailSort implements ComparativeSort {
    @Override
    public void sort(List<Network> networks, Comparator<Network> comparator) {

        int size = networks.size();
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < size - 1; i++) {
                swapped = isSwapped(networks, comparator, swapped, i);
            }

            if (!swapped) {
                break;
            }

            swapped = false;

            for (int i = size - 2; i >= 0; i--) {
                swapped = isSwapped(networks, comparator, swapped, i);
            }
        } while (swapped);

    }

    static boolean isSwapped(List<Network> networks, Comparator<Network> comparator, boolean swapped, int i) {
        if (comparator.compare(
                networks.get(i),
                networks.get(i + 1)
        ) > 0) {
            Network aux = networks.get(i);
            networks.set(i, networks.get(i + 1));
            networks.set(i + 1, aux);
            swapped = true;
        }
        return swapped;
    }
}
