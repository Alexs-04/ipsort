package com.korebit.sort;


public class MergeSort implements ComparativeSort {

    @Override
    public void sort(
            java.util.List<com.korebit.model.Network> networks,
            java.util.Comparator<com.korebit.model.Network> comparator
    ) {
        if (networks.size() < 2) {
            return;
        }

        int mid = networks.size() / 2;
        java.util.List<com.korebit.model.Network> left = new java.util.ArrayList<>(networks.subList(0, mid));
        java.util.List<com.korebit.model.Network> right = new java.util.ArrayList<>(networks.subList(mid, networks.size()));

        sort(left, comparator);
        sort(right, comparator);

        merge(networks, left, right, comparator);
    }

    private void merge(
            java.util.List<com.korebit.model.Network> networks,
            java.util.List<com.korebit.model.Network> left,
            java.util.List<com.korebit.model.Network> right,
            java.util.Comparator<com.korebit.model.Network> comparator
    ) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                networks.set(k++, left.get(i++));
            } else {
                networks.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            networks.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            networks.set(k++, right.get(j++));
        }
    }
}
