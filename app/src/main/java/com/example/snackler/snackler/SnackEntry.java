package com.example.snackler.snackler;

import android.graphics.Bitmap;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jake on 12/5/2016.
 */

public class SnackEntry {

    private String snackType;
    private Bitmap imageBitmap;
    private int quantity;                   //We should decide how we want to do quantity, estimate mass somehow? or volume
    private double servingSize;
    private Date timestamp;

    //Macros more can be added later
    private int calories;
    private int protein;
    private int fat;
    private int carbohydrates;
    private int sugar;
    private int salt;

    public SnackEntry(String snackTypeIn) {
        snackType = snackTypeIn;

        Calendar c = Calendar.getInstance();
        long seconds = c.get(Calendar.SECOND);

        timestamp = new Date(seconds);
    }

    //Setters

    public void setImage(Bitmap imageBitmapIn) {
        imageBitmap = imageBitmapIn;
    }

    public void setQuantity(int quantityIn) {
        quantity = quantityIn;
    }

    public void setServingSize(double servingSizeIn) {
        servingSize = servingSizeIn;
    }

    public void setCalories(int caloriesIn) {
        calories = caloriesIn;
    }

    public void setProtein(int proteinIn) {
        protein = proteinIn;
    }

    public void setFat(int fatIn) {
        fat = fatIn;
    }

    public void setCarbohydrates(int carbsIn) {
        carbohydrates = carbsIn;
    }

    public void setSugar(int sugarIn) {
        sugar = sugarIn;
    }

    public void setSalt(int saltIn) {
        salt = saltIn;
    }


    //Getters

    public String getSnackType() {
        return snackType;
    }

    public Bitmap getImage() {
        return imageBitmap;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getServingSize() {
        return servingSize;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getSugar() {
        return sugar;
    }

    public int getSalt() {
        return salt;
    }

    public Date getTime() {return timestamp;}
}
