package com.korebit.sort;

import com.korebit.model.Network;

import java.util.List;
import java.util.function.ToIntFunction;

public non-sealed interface NoComparativeSort extends Sort {
    void sort(
            List<Network> networks,
            ToIntFunction<Network> keyExtractor //TODO: Not compatible with parameters other than integers.
    );
}
