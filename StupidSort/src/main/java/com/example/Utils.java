package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static final Utils UTILS = new Utils();
    private long countdownStartTime = 0;

    private Utils(){
    }

    public static Utils getInstance(){
        return UTILS;
    }

    public void startCountdown(){
        countdownStartTime = System.currentTimeMillis();
    }

    public void endCountdown(){
        long countdownEndTime = System.currentTimeMillis();
        System.out.println("Time counted: " + (countdownEndTime-countdownStartTime));
    }

    public void createRandomNumbersFile(){
        try {
            FileWriter writer = new FileWriter("random_numbers.txt");
            for (int i = 0; i < 999999; i++) {  // generate 100 random numbers
                writer.write(String.format("%.6f", ((Math.random()-0.5)*1000) ) + "\n");  // write random number to file
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<Number> readRandomNumbersFile(){
        List<Number> lista = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("random_numbers.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                lista.add(Double.parseDouble(line));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
