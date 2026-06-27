package com.korebit.sort;

import com.korebit.model.Network;

import java.util.List;
import java.util.function.ToIntFunction;

public class CountingSort implements NoComparativeSort {

    @Override
    public void sort(List<Network> networks,
                     ToIntFunction<Network> keyExtractor) {

        if (networks.isEmpty()) {
            return;
        }

        int min = keyExtractor.applyAsInt(networks.getFirst());
        int max = min;

        for (Network network : networks) {

            int key = keyExtractor.applyAsInt(network);

            if (key < min) {
                min = key;
            }

            if (key > max) {
                max = key;
            }
        }

        int[] count = new int[max - min + 1];

        for (Network network : networks) {
            count[keyExtractor.applyAsInt(network) - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        Network[] output = new Network[networks.size()];

        for (int i = networks.size() - 1; i >= 0; i--) {

            Network network = networks.get(i);
            int key = keyExtractor.applyAsInt(network);

            output[count[key - min] - 1] = network;
            count[key - min]--;
        }

        for (int i = 0; i < networks.size(); i++) {
            networks.set(i, output[i]);
        }
    }
}
