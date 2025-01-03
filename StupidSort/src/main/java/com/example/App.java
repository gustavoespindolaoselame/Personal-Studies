package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Double> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(0.0,4.0,5.0,2.0,16.05545,999999489.0));

        double maxDecimalPlaces = lista.stream().reduce((sub, number) -> {
            String numberAsString = Double.toString(number);
            if (numberAsString.contains(".")) {
                String decimalPart = numberAsString.split("\\.")[1];
                return (Math.max(sub, decimalPart.length()));
            }
            return 0.0;
        }).orElse(0.0);

        Double[] sorted = new Double[(int) (lista.stream().max(Comparator.naturalOrder()).orElse(null)+1)];

        // lista.forEach((double) -> {
        //     sorted[(int) (double)] = double;
        // });

        Arrays.stream(sorted).filter(value -> value != null).forEach(System.out::println);
    }
}