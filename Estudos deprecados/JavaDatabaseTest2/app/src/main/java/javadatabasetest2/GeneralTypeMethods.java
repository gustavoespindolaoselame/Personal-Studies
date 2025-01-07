package javadatabasetest2;

import java.util.Scanner;

public class GeneralTypeMethods {
    public static void PressToProceed(Scanner scanner) {
        System.out.println("Press any key to proceed;");
        scanner.nextLine();
        ClearScreen();
    }

    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String returnTableName(Scanner scanner) {
        System.out.println("Which table do you choose?");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static void mainLoop(GeneralTypeVariables parclass){
        while (true) { 
            System.out.println("""
                    What would you like to do with your table?
                    (1) - Create Table
                    (2) - Instanciate Existing Table
                    (3) - Insert into Table
                    (4) - Select Table""");
            int scannerChoice=999;
            while(scannerChoice<1||scannerChoice>4){
                scannerChoice=parclass.getScanner().nextInt();
            }
            switch (scannerChoice) {
                case 1 ->
                    {
                        String currentTableName = Queries.defineName(parclass.getScanner());
                        parclass.getQueries().put(currentTableName, new Queries(parclass, currentTableName));
                        parclass.getQueries().get(currentTableName).Create(parclass);
                    }
                case 2 ->
                {
                    String currentTableName = Queries.defineName(parclass.getScanner());
                    parclass.getQueries().put(currentTableName, new Queries(parclass, currentTableName));
                    parclass.getQueries().get(currentTableName).instanciateExistingTable(parclass);
                }
                case 3 -> parclass.getQueries().get(returnTableName(parclass.getScanner())).InsertInto(parclass);
                case 4 -> parclass.getQueries().get(returnTableName(parclass.getScanner())).Select(parclass);
                default -> throw new AssertionError();
            }
        }
    }
}
