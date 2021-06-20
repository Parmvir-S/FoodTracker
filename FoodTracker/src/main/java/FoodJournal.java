/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author parmv
 */
import java.util.ArrayList;

public class FoodJournal {
    private ArrayList<FoodItem> foodJournal;
    
    public FoodJournal() {
        this.foodJournal = new ArrayList<>();
    }

    public void addToJournal(FoodItem foodItem) {
        this.foodJournal.add(foodItem);
    } 
    
    public void removeFromJournal(String foodName) {
        FoodItem toRemove = this.foodJournal.get(0);
        for (FoodItem food: this.foodJournal) {
            if (food.getFoodName().equals(foodName)) {
                toRemove = food;
            }
        }
        this.foodJournal.remove(toRemove);
    }
    
    public int getTotalCalories() { 
        int totalCalories = 0;
        for (FoodItem food: foodJournal) {
            totalCalories += food.getCalories();
        }
        return totalCalories;
    }
    
    public void printAllItems() {
        for (FoodItem food: this.foodJournal) {
            System.out.println(food);
        }
    }
    
    public void printTotalStats() {
        int totalCalories = 0;
        int totalFat = 0;
        int totalProtein = 0;
        int totalCarbs = 0;
        
        for (FoodItem food: this.foodJournal) {
            totalCalories += food.getCalories();
            totalFat += food.getFat();
            totalProtein += food.getProtein();
            totalCarbs += food.getCarbs();
        }
        System.out.println("");
        System.out.println("--Current Stats--");
        System.out.println("Total Calories: " + totalCalories);
        System.out.println("Total Fat: " + totalFat);
        System.out.println("Total Protein: " + totalProtein);
        System.out.println("Total Carbs: " + totalCarbs);
    }
}
