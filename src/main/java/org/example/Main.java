package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {
    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {
        String connectionString = "jdbc:postgresql://localhost:5432/University";

        Properties props = new Properties();

        try{
            InputStream input = Main.class.getClassLoader().getResourceAsStream("db.properties");
            props.load(input);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
    }
}