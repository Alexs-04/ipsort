package com.korebit.sort;

public class QuickSort implements ComparativeSort {

    @Override
    public void sort(
            java.util.List<com.korebit.model.Network> networks,
            java.util.Comparator<com.korebit.model.Network> comparator
    ) {
        if (networks == null || networks.size() < 2) {
            return;
        }
        quickSort(networks, 0, networks.size() - 1, comparator);
    }

    private void quickSort(
            java.util.List<com.korebit.model.Network> networks,
            int low,
            int high,
            java.util.Comparator<com.korebit.model.Network> comparator
    ) {
        if (low < high) {
            int pivotIndex = partition(networks, low, high, comparator);
            quickSort(networks, low, pivotIndex - 1, comparator);
            quickSort(networks, pivotIndex + 1, high, comparator);
        }
    }

    private int partition(
            java.util.List<com.korebit.model.Network> networks,
            int low,
            int high,
            java.util.Comparator<com.korebit.model.Network> comparator
    ) {
        com.korebit.model.Network pivot = networks.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(networks.get(j), pivot) <= 0) {
                i++;
                java.util.Collections.swap(networks, i, j);
            }
        }
        java.util.Collections.swap(networks, i + 1, high);
        return i + 1;
    }
}
