package javadatabasetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Methods {

    private ResultSet rs;

    public Methods() {
        System.out.println("Alphabet System Built");
        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:alphabet.db");
                Statement statement = connection.createStatement();) {
            statement.setQueryTimeout(30);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public void addAlphabet(String alphabet) {
        int index = 0;
        System.out.println("Adding Alphabet");
        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:alphabet.db");
                Statement statement = connection.createStatement();) {
            statement.setQueryTimeout(30);
            statement.executeUpdate("drop table if exists alphabet");
            statement.executeUpdate("create table alphabet (id integer, letter char)");
            for (; index < alphabet.length(); index++) {
                statement.executeUpdate(
                        "insert into alphabet values(" + (index + 1) + ", '" + alphabet.charAt(index) + "')");
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public void readAlphabet() {
        System.out.println("Reading Alphabet");
        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:alphabet.db");
                Statement statement = connection.createStatement();) {
            statement.setQueryTimeout(30);
            this.rs = statement.executeQuery("select * from alphabet");
            while (rs.next()) {
                System.out.print("letter = " + rs.getString("letter") + " | ");
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
