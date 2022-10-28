package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class Main {
    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {
        String connectionString = "jdbc:postgresql://localhost:5432/tutorial4";

        Properties props = new Properties();

        try {
            InputStream input = Main.class.getClassLoader().getResourceAsStream("db.properties");
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(connectionString, props);
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * from \"books\"");

            while (results.next()) {
                System.out.printf("%s\n", results.getString("booktitle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}