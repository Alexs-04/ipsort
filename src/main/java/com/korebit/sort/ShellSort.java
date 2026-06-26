package com.korebit.sort;

import com.korebit.model.Network;

import java.util.Comparator;
import java.util.List;

public class ShellSort implements ComparativeSort {


    @Override
    public void sort(List<Network> networks, Comparator<Network> comparator) {
        int n = networks.size();

        for(int gap = n / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < n; i++) {
                Network temp = networks.get(i);
                int j;
                for(j = i; j >= gap && comparator.compare(networks.get(j - gap), temp) > 0; j -= gap) {
                    networks.set(j, networks.get(j - gap));
                }
                networks.set(j, temp);
            }
        }
    }
}
