package com.korebit;

import com.korebit.model.Data;
import com.korebit.util.SortUtils;

public class Main {
    public static void main(String[] args) {

        Data.printTheFirstHundredNetworks();
        System.out.println("------------------");

        var selectSort = SortUtils.orchestratorSortByIdentifier();

        System.out.printf("Algoritmo utilizado: %s%n", selectSort.algorithm());

        System.out.println("------------------");
        Data.printTheFirstHundredNetworks();
    }
}