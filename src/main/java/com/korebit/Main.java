package com.korebit;

import com.korebit.model.Data;
import com.korebit.util.SortUtils;

public class Main {
    public static void main(String[] args) {

        System.out.printf("%b%n", SortUtils.comprobateSortByIdentifier);
        Data.printTheFirstHundredNetworks();
        System.out.println("------------------");

        var selectSort = SortUtils.orchestratorSortByIdentifier();

        System.out.printf("Algoritmo utilizado: %s%n", selectSort.algorithm());

        System.out.printf("%b%n", SortUtils.comprobateSortByIdentifier);
        System.out.println("------------------");
        Data.printTheFirstHundredNetworks();
    }
}