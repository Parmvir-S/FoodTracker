/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author parmv
 */
public class Person {
    private String name;
    private FoodJournal foodJournal;
    private int age;
    private int maxCalories;
    
    public Person(String name, int age, int MaxCalories, FoodJournal foodJournal) {
        this.name = name;
        this.age = age;
        this.maxCalories = MaxCalories;
        this.foodJournal = foodJournal;
    }
    
    public FoodJournal getFoodJournal() {
        return this.foodJournal;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getMaxCalories() {
        return this.maxCalories;
    }
    
}
