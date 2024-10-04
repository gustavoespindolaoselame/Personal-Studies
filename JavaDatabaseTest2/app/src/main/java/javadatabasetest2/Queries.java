package javadatabasetest2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public final class Queries {
    private final String tableName;
    private final HashMap<String, String> columns = new HashMap<>();
    private ResultSet rs;

    public static String defineName(Scanner scanner) {
        GeneralTypeMethods.ClearScreen();
        System.out.println("Give your table a name");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public Queries(GeneralTypeVariables parClass, String tableName){
        this.tableName=tableName;
    }

    public void instanciateExistingTable(GeneralTypeVariables parClass){
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + this.tableName + ".db", "gustavo", "745231968");
                Statement statement = connection.createStatement();) {
                    System.out.println("access");
            statement.setQueryTimeout(30);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        GeneralTypeMethods.PressToProceed(parClass.getScanner());
    }

    public void Create(GeneralTypeVariables parClass) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:" + this.tableName + ".db");
                Statement statement = connection.createStatement();) {
            statement.setQueryTimeout(30);
            statement.executeUpdate("drop table if exists " + this.tableName);
            while (true) {
                System.out.println("Add column name and variable type: (Press x to move on)");
                String scannerChoice = parClass.getScanner().nextLine();
                if ("x".equals(scannerChoice)) {
                    break;
                }
                this.columns.put(scannerChoice, parClass.getScanner().nextLine());
            }
            statement.executeUpdate("create table " + this.tableName + " ("
                    + this.columns.toString().replace('=', ' ').substring(1, this.columns.toString().length() - 1)
                    + ")");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        GeneralTypeMethods.PressToProceed(parClass.getScanner());
    }

    public void Alter() {
    }

    public void InsertInto(GeneralTypeVariables parClass) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:" + this.tableName + ".db");
                Statement statement = connection.createStatement();) {
            statement.setQueryTimeout(30);
            boolean insertIntoControl = true;
            while (insertIntoControl) {
                String columnInsertInto = "";
                System.out.println("Insert the columns you'd like to add values to: (Press x to move on)");
                while (true) {       
                    columnInsertInto = columnInsertInto.concat(parClass.getScanner().nextLine() + ", ");
                    if (columnInsertInto.contains("x")) {
                        columnInsertInto = columnInsertInto.substring(0, columnInsertInto.length() - 5);
                        break;
                    }
                }
                String valuesInsertInto = "";
                System.out.println("Insert the values you'd like to insert into: (Press x to move on)");
                while (insertIntoControl) {
                    valuesInsertInto = valuesInsertInto.concat(parClass.getScanner().nextLine() + ", ");
                    if (valuesInsertInto.contains("x")) {
                        valuesInsertInto = valuesInsertInto.substring(0, valuesInsertInto.length() - 5);
                        insertIntoControl = false;
                    }
                }
                statement.executeUpdate(
                        "insert into " + this.tableName + " (" + columnInsertInto + ") values (" + valuesInsertInto
                                + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        GeneralTypeMethods.PressToProceed(parClass.getScanner());
    }

    public void Update() {
    }

    public void Delete() {
    }

    public void Join() {
    }

    public void Select(GeneralTypeVariables parClass) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:" + this.tableName + ".db");
                Statement statement = connection.createStatement();) {
            statement.setQueryTimeout(30);
            this.rs = statement.executeQuery("select * from " + this.tableName);
            while (rs.next()) {
                for(int i=1;i<=this.columns.size();i++){
                    System.out.print(rs.getString(i) + "| ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        GeneralTypeMethods.PressToProceed(parClass.getScanner());
    }
}
