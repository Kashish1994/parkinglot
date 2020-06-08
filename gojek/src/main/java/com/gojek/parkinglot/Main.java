package com.gojek.parkinglot;

import com.gojek.parkinglot.exceptions.GoException;
import com.gojek.parkinglot.utils.GoHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = br.readLine().trim();
                if (input.endsWith(".txt")) {
                    File file = new File(input);
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        GoHelper.execute(data);
                    }
                    break;
                } else if (GoHelper.execute(input)) {
                    break;
                }
            } catch (GoException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("UnExpected error occured");
            }

        }


    }
}
