/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author parmv
 */
public class FoodItem {
    private String foodName;
    private int calories;
    private int fat;
    private int protein;
    private int carbs;
    
    public FoodItem(String foodName, int calories, int fat, int protein, int carbs) {
        this.foodName = foodName;
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.carbs = carbs;
    }
    
    public String getFoodName() {
        return this.foodName;
    }
    
    public int getCalories() {
        return this.calories;
    }
    
    public int getFat() {
        return this.fat;
    }
    
    public int getProtein() {
        return this.protein;
    }
    
    public int getCarbs() {
        return this.carbs;
    }
    
    public String toString() {
        return this.foodName + " has " + this.calories + " calories, " + this.fat + " grams of fat, " + this.protein + " grams of protein, and " + this.carbs + " grams of carbohydrates";            
    }
}
