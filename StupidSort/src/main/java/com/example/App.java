package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Utils.getInstance().createRandomNumbersFile();
        List<Number> lista = Utils.getInstance().readRandomNumbersFile();

        //Starts the sorter
        Utils.getInstance().startCountdown();
        int highestDecimalSize = 0;
        Number highestValue = 0.0;
        Number lowestNegativeValue = 0.0;

        //Finds the highest decimal size, highest and lowest values,
        // this is because the size of a array has to be a integer,
        // thus we use these values to transform the highest value into one

        for (Number number : lista) {
            String numberAsString = String.format("%.6f", number.doubleValue());
            if (numberAsString.contains(".")) {
                String decimalPart = numberAsString.split("\\.")[1].replaceAll("0*$", "");
                highestDecimalSize = Math.max(highestDecimalSize, decimalPart.length());
            }
            if (number.doubleValue() > highestValue.doubleValue()) {
                highestValue = number;
            }
            if (number.doubleValue()<0&&number.doubleValue()<lowestNegativeValue.doubleValue()){
                lowestNegativeValue = number;
            }
        }

        //Here we define the size of the array and the array
        int arraySize = (int) ((highestValue.doubleValue()+(lowestNegativeValue.doubleValue()*-1)) * Math.pow(10, highestDecimalSize))+1;
        Number[] toBeSorted = new Number[arraySize];

        //Here, since lambda expressions require final values i literally just made them values
        final int foo = highestDecimalSize;
        final Number bar = lowestNegativeValue.doubleValue()*-1;
        lista.forEach(number ->
                toBeSorted[(int) ((number.doubleValue() + bar.doubleValue()) * Math.pow(10, foo))] = number);
        List<Number> sortedList = Arrays.stream(toBeSorted)
                .filter(Objects::nonNull)
                .toList();


        Utils.getInstance().endCountdown();

        Utils.getInstance().startCountdown();
        lista.sort((a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
        Utils.getInstance().endCountdown();
    }
}