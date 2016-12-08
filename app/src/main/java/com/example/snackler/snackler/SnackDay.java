package com.example.snackler.snackler;

import java.util.ArrayList;

/**
 * Created by romolatty on 12/5/16.
 */

public class SnackDay {

    private class NutritionInfo{
         int numCalories;
         int numCarbs;
         int numProtein;
         int numFat;
         int numSugar;
         int numSodium;

       public NutritionInfo(int calories, int carbs, int protein, int fat, int sugar, int sodium){
           numCalories = calories;
           numCarbs = carbs;
           numProtein = protein;
           numFat = fat;
           numSugar = sugar;
           numSodium = sodium;
        }

    }



    private int numEntries;
    private ArrayList<SnackEntry> entries;
    private int numCalories;
    private int numCarbs;
    private int numProtein;
    private int numFat;
    private int numSugar;
    private int numSodium;

    public int dailyCalories;
    public int dailyCarbs;
    public int dailyProtein;
    public int dailyFat;
    public int dailySugar;
    public int dailySodium;



    String date;




    public SnackDay(String date){
        this.date = date;
        this.entries = new ArrayList<SnackEntry>();
        numEntries = 0;
        numCalories = 0;
        numCarbs = 0;
        numProtein = 0;
        numFat = 0;
        numSugar = 0;
        numSodium = 0;

        dailyCalories = 0;
        dailyCarbs = 0;
        dailyProtein = 0;
        dailyFat = 0;
        dailySugar = 0;
        dailySodium = 0;

    }



    public void addEntry(SnackEntry entry){
        entries.add(entry);
        numEntries++;
    }
    public void removeEntry(SnackEntry entry){
        entries.remove(entry);
        numEntries--;
    }

    public NutritionInfo loadData(){
        int retCal = 0;
        int retCarb = 0;
        int retProtein = 0;
        int retFat = 0;
        int retSugar = 0;
        int retSodium = 0;

        for(SnackEntry s: entries){
            retCal += s.getCalories() ;
            retCarb += s.getCarbohydrates() ;
            retProtein += s.getProtein() ;
            retFat += s.getFat() ;
            retSugar += s.getSugar() ;
            retSodium += s.getSalt();

        }

        return new NutritionInfo(retCal, retCarb, retProtein, retFat, retSugar, retSodium);

    }

    public int countCalories(){
        int ret = 0;
        for(SnackEntry s: entries){
            ret += s.getCalories() ;
        }

        return ret;
    }

    public int countCarbs(){
        int ret = 0;
        for(SnackEntry s: entries){
            ret += s.getCarbohydrates() ;
        }

        return ret;
    }

    public int countProtein(){
        int ret = 0;
        for(SnackEntry s: entries){
            ret += s.getProtein() ;
        }

        return ret;
    }

    public int countFat(){
        int ret = 0;
        for(SnackEntry s: entries){
            ret += s.getFat() ;
        }

        return ret;
    }

    public int countSugar(){
        int ret = 0;
        for(SnackEntry s: entries){
            ret += s.getSugar() ;
        }

        return ret;
    }

    public int countSodium(){
        int ret = 0;
        for(SnackEntry s: entries){
            ret += s.getSalt() ;
        }

        return ret;
    }
/*
    public GraphView createGraph(String type){

        switch (type){
            case "calories":

                break;
            case "carbs":
                break;
            case "protein":
                break;
            case "fat":
                break;
            case "sugar":
                break;
            case "sodium":
                break;
            case "all":
                break;

        }

        return null;

    }
*/


}
