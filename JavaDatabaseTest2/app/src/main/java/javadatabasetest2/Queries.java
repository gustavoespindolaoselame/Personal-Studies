package javadatabasetest2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Queries {
    private String tableName;
    private HashMap<String, String> columns = new HashMap<String, String>();
    private ResultSet rs;

    public Queries(ParClass parClass) {
        System.out.println("Give your table a name");
        tableName = parClass.getScanner().nextLine();
    }

    public boolean Create(ParClass parClass) {
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
        return true;
    }

    public boolean Alter() {
        return true;
    }

    public boolean InsertInto(ParClass parClass) {
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
        return true;
    }

    public boolean Update() {
        return true;
    }

    public boolean Delete() {
        return true;
    }

    public boolean Join() {
        return true;
    }

    public boolean Select() {
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
        return true;
    }
}
