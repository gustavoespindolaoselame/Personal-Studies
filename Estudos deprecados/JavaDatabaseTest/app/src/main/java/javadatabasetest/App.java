package javadatabasetest;

import java.util.Scanner;

public class App {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showOptions(){
        System.out.println("""
            Press the following keys;
            (1) - Read DB
            (2) - Implement Portuguese
            (3) - Implement English
            (4) - Implement German
            (5) - Implement French
            (6) - Implement Spanish""");
    }

    public static void pressToProceed(Scanner scanner) {
        System.out.println("Press any key to proceed;");
        scanner.nextLine();
        scanner.nextLine();
        clearScreen();
    }

    public static void mainSwitchCase(Parameters parameters){
        parameters.choice = parameters.scanner.nextInt();
        clearScreen();

        while (true) {
            showOptions();
            parameters.choice = 999;
            while (parameters.choice < 0 || parameters.choice > 6) {
                parameters.choice = parameters.scanner.nextInt();
            }
            switch (parameters.choice) {
                case 1 -> parameters.buildDB.readAlphabet();
                case 2 -> parameters.buildDB.addAlphabet(Alphabets.PORTUGUESE.getAlphabet());
                case 3 -> parameters.buildDB.addAlphabet(Alphabets.ENGLISH.getAlphabet());
                case 4 -> parameters.buildDB.addAlphabet(Alphabets.GERMAN.getAlphabet());
                case 5 -> parameters.buildDB.addAlphabet(Alphabets.FRENCH.getAlphabet());
                case 6 -> parameters.buildDB.addAlphabet(Alphabets.SPANISH.getAlphabet());
                default -> throw new AssertionError();
            }
            pressToProceed(parameters.scanner);
        }
    }

    public static void main(String[] args) {
        clearScreen();
        showOptions();
        Parameters parameters = new Parameters();
        mainSwitchCase(parameters);
    }
}
