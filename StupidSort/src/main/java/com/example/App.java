package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Number> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(0.0, 4.0, 5.0, 2.0, 16.0554, 9999.0));
        int maxDecimalSize = 0;
        Number highestValue = 0.0;
        for (Number number : lista) {
            String numberAsString = String.format("%.15f", number); // Format to 15 decimal places
            if (numberAsString.contains(".")) {
                String decimalPart = numberAsString.split("\\.")[1].replaceAll("0*$", ""); // Trim trailing zeros
                maxDecimalSize = Math.max(maxDecimalSize, decimalPart.length());
            }
            if ((double) number > (double) highestValue) {
                highestValue = number;
            }
        }
        int arraySize = (int) (highestValue.doubleValue() * Math.pow(10, maxDecimalSize))+1;
        Number[] toBeSorted = new Number[arraySize];
        final int foo = maxDecimalSize;
        lista.forEach(number ->
                toBeSorted[(int) (number.doubleValue() * Math.pow(10, foo))] = number);
        List<Number> sortedList = Arrays.stream(toBeSorted)
                .filter(Objects::nonNull)
                .toList();
        sortedList.stream().forEach(System.out::println);
    }
}