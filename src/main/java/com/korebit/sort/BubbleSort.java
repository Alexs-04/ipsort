package com.korebit.sort;

import com.korebit.model.Network;

import java.util.Comparator;
import java.util.List;

public class BubbleSort implements Sort{

    @Override
    public void sort(List<Network> networks, Comparator<Network> comparator) {

        int n = networks.size();

        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < n - 1; i++) {

                swapped = CocktailSort.isSwapped(networks, comparator, swapped, i);
            }

            n--;

        } while (swapped);
    }
}
