package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import static java.lang.System.exit;

//functions for adding values to months
//checks for appropriate values
//totals

public class Main {
    private static Main miniMain;
    //input
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //instance of data for function calls
    private DataList months = DataList.instance();

    //instance of main
    public static Main instance() {
        if (miniMain == null) {
            return miniMain = new Main();
        } else {
            return miniMain;
        }
    }




    //main
    public static void main(String[] args) {
        Main.instance().BillingProcess();
    }

    //process of system
    //load in previous data
    //handle commands to call functions
    public void BillingProcess() {
        try{
            months.ReloadMonths();
        }catch (FileNotFoundException e) {
            exit(0);
        }
        boolean done = false;
        GeneralInterface();
        while(!done){
            switch(getCommand()){
                case 1:
                    months.Output();
                    break;
                case 2:
                    AddBills();
                    System.out.println("Complete.");
                    break;
                case 3:
                    months.CreateMonth();
                    System.out.println("Complete.");
                    break;
                case 4:
                    GeneralInterface();
                    break;
                case 0:
                    done = true;
                    try{months.SaveMonths();} catch (IOException e) {exit(1);}
                    System.out.println("Thank you.");
                    break;
            }
        }
    }

    //convert string input to an integer for commands
    public int getCommand() {
        do {
            try {
                int value = Integer.parseInt(getToken("Enter Command: Enter 4 for help"));
                if (value >= 0 ) {
                    return value;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Enter a number");
            }
        } while (true);
    }

    //reading a string input
    public String getToken(String prompt) {
        do {
            try {
                System.out.println(prompt);
                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
                if (tokenizer.hasMoreTokens()) {
                    return tokenizer.nextToken();
                }
            } catch (IOException ioe) {
                exit(0);
            }
        } while (true);
    }

    //input values
    public static void GeneralInterface(){
        System.out.println("What would you like to do?");
        System.out.println("1: View History");
        System.out.println("2: Add bills");
        System.out.println("3: Add Month");
        System.out.println("0: Exit");
    }

    // start BillsUI
    public void AddBills(){
        BillsUI billsUI = new BillsUI();
        billsUI.BillsProcess();
    }
}
