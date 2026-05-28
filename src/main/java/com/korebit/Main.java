package com.korebit;

import com.korebit.model.Data;


public class Main {
    public static void main(String[] args) {
        Data.getNetworks().forEach(System.out::println);
    }
}