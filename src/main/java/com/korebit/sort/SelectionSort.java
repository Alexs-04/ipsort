package com.korebit.sort;

import com.korebit.model.Network;

import java.util.Comparator;
import java.util.List;

public class SelectionSort implements ComparativeSort {

    @Override
    public void sort(List<Network> networks, Comparator<Network> comparator) {

        int n = networks.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(networks.get(j), networks.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Network aux = networks.get(i);
                networks.set(i, networks.get(minIndex));
                networks.set(minIndex, aux);
            }
        }
    }
}
