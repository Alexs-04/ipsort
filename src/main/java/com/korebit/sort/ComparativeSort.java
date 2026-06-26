package com.korebit.sort;

import com.korebit.model.Network;

import java.util.Comparator;
import java.util.List;

public non-sealed interface ComparativeSort extends Sort {
    void sort(
            List<Network> networks,
            Comparator<Network>comparator
    );
}
