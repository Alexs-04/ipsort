package com.korebit.sort;

import com.korebit.model.Network;

import java.util.Comparator;
import java.util.List;

public class InsertionSort implements ComparativeSort {
    @Override
    public void sort(List<Network> networks, Comparator<Network> comparator) {
        int n = networks.size();

        for (int i = 1; i < n; i++) {
            Network key = networks.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(networks.get(j), key) > 0) {
                networks.set(j + 1, networks.get(j));
                j--;
            }
            networks.set(j + 1, key);
        }
    }
}
