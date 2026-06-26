package com.korebit.sort;

public class SortFactory {

    public static Sort getSort(String sortType) {
        return switch (sortType.toLowerCase()) {
            case "bubble" -> new BubbleSort();
            case "insertion" -> new InsertionSort();
            case "cocktail" -> new CocktailSort();
            case "counting" -> new CountingSort();
            case "radix" -> new RadixSort();
            case "selection" -> new SelectionSort();
            case "shell" -> new ShellSort();
            default -> throw new IllegalArgumentException("Invalid sort type: " + sortType);
        };
    }
}
