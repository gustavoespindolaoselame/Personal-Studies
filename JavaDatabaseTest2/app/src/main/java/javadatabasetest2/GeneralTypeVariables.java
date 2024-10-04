package javadatabasetest2;
import java.util.HashMap;
import java.util.Scanner;

public class GeneralTypeVariables {
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Queries> queries = new HashMap<>();

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public HashMap<String, Queries> getQueries() {
        return queries;
    }

    public void setQueries(HashMap<String, Queries> queries) {
        this.queries = queries;
    }
}
