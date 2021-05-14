package com.company;

import javax.swing.text.Utilities;

public class MonthExpenses {

    private String monthYear;
    private float total = 0;
    private float eachTotal = 0;
    private float utilities = 0;
    private float rent = 0;
    private float misc = 0;
    private float internet = 0;
    private float food = 0;

    public MonthExpenses(){}
    public MonthExpenses(String date){
        monthYear = date;
    }

    //private to prevent unintended breaking of totals
    private void SetTotal(float total){
        this.total = total;
    }
    private void SetEachTotal(float eTotal){
        eachTotal = eTotal;
    }

    public void SetUtilities(float util){
        //System.out.printf("Set Utilities to $%.2f\n", util );
        utilities = util;
        CalcTotals();
    }

    //sets monthYear to specified key value
    public void AddMonth(String str){
        monthYear = str;
    }

    //multiple Utilities bills, running total
    public void AddUtilities(float util){
        utilities += util;
        CalcTotals();
    }

    //Rent is one bill, sets to value
    public void AddRent(float rent) {
        this.rent = rent;
        CalcTotals();
    }

    //add value to Misc total, running total
    public void AddMisc(float misc){
        this.misc += misc;
        CalcTotals();
    }

    //internet is one bill, sets to value
    public void SetInternet(float inter){
        internet = inter;
        CalcTotals();
    }

    //add value onto Food total, running total
    public void AddFood(float val){
        food += val;
        CalcTotals();
    }

    //calculates total and total/2 for end of grid
    private void CalcTotals(){
        total = 0;
        eachTotal = 0;
        total += utilities + rent + misc + + food + internet;
        eachTotal = total/2;
    }

    //output a line on the grid
    public void OutputGrid(){
        System.out.print("|");
        System.out.format("%15s|",monthYear);
        outputVal(rent);
        outputVal(utilities);
        outputVal(internet);
        outputVal(food);
        outputVal(misc);
        outputVal(total);
        outputVal(eachTotal);
        System.out.println();
    }

    //output float to fit grid
    private void outputVal(float value){ System.out.format("$%14.2f|",value); }

    //getter functions
    public String getMonthYear(){
        return monthYear;
    }
    public float getRent(){ return rent; }
    public float getUtilities(){ return utilities; }
    public float getInternet(){ return internet; }
    public float getFood(){ return food; }
    public float getMisc(){ return misc; }
    public float getTotal(){ return total; }
    public float getEachTotal(){ return eachTotal; }

}
