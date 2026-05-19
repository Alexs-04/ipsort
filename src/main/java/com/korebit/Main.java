package com.korebit;

import com.korebit.model.Data;
import com.korebit.util.OpenFile;

public class Main {
    public static void main(String[] args) {
        Data.getNetworks().forEach(System.out::println);
       new OpenFile().parrotLive();
    }
}