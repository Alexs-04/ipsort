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

                if (comparator.compare(
                        networks.get(i),
                        networks.get(i + 1)
                ) > 0) {

                    Network aux = networks.get(i);

                    networks.set(i, networks.get(i + 1));
                    networks.set(i + 1, aux);

                    swapped = true;
                }
            }

            n--;

        } while (swapped);
    }
}
