package org.example.cardgame.events;

import java.util.Scanner;

public class playObserver {
    Scanner scanner;

    public static playObserver playObserverGetInstance(){
        return new playObserver();
    }

    private playObserver(){
        scanner = new Scanner(System.in);
    }

    public Scanner getScanner(){
        return scanner;
    }
}
