package com.gojek.parkinglot;

import com.gojek.parkinglot.utils.GoHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true){
                String input = br.readLine();
                if (GoHelper.execute(input)) {
                    break;
                }
            }
        }
        catch (Exception e){

        }
    }
}
