package com.korebit.sort;

import com.korebit.model.Network;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.ToIntFunction;

public class RadixSort implements NoComparativeSort {

    private static final int RADIX = 10;

    @Override
    public void sort(
            List<Network> networks,
            ToIntFunction<Network> keyExtractor
    ) {

        if (networks.isEmpty()) {
            return;
        }

        int max = 0;

        for (Network network : networks) {
            int value = keyExtractor.applyAsInt(network);

            if (value > max) {
                max = value;
            }
        }

        for (int placement = 1;
             max / placement > 0;
             placement *= RADIX) {

            List<Queue<Network>> buckets =
                    new ArrayList<>(RADIX);

            for (int i = 0; i < RADIX; i++) {
                buckets.add(new LinkedList<>());
            }

            for (Network network : networks) {

                int value =
                        keyExtractor.applyAsInt(network);

                int digit =
                        (value / placement) % RADIX;

                buckets.get(digit)
                        .add(network);
            }

            int index = 0;

            for (Queue<Network> bucket : buckets) {

                while (!bucket.isEmpty()) {

                    networks.set(
                            index++,
                            bucket.remove()
                    );
                }
            }
        }
    }
}
