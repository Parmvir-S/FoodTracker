/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author parmv
 */
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Scanner scanner;
    private People community;
    
    public UserInterface(Scanner scanner, People community) {
        this.scanner = scanner;
        this.community = community;
    }
    
    public void start() {
        while (true) {
            System.out.println("");    
            System.out.println("Commands:");
            System.out.println("Add - Add New User");
            System.out.println("Remove - Remove User");
            System.out.println("Access - Specific User Info");
            System.out.println("Exit - Quit The Program");
            String command = this.scanner.nextLine().toLowerCase();
            System.out.println("");
            
            if (command.equals("add")) {
                add();
            }
            
            if (command.equals("remove")) {
                remove();
            }
            
            if (command.equals("access")) {
                System.out.print("Person: ");
                String name = this.scanner.nextLine();
                
                if (check(name)) {
                    while (true) {
                        System.out.println("");
                        System.out.println("Commands:");
                        System.out.println("Add - Add Food");
                        System.out.println("Remove - Remove Food");
                        System.out.println("Stats - Get Current Food Stats");
                        System.out.println("Update - Update BodyWeight");
                        System.out.println("Exit - Go To Main Menu");
                        String userCommand = this.scanner.nextLine().toLowerCase();
                        System.out.println("");

                        if (userCommand.equals("add")) {
                            System.out.print("Food Name: ");
                            String foodName = this.scanner.nextLine();

                            System.out.print("Calories: ");
                            int calories = Integer.valueOf(this.scanner.nextLine());

                            System.out.print("Fat: ");
                            int fat = Integer.valueOf(this.scanner.nextLine());

                            System.out.print("Protein: ");
                            int protein = Integer.valueOf(this.scanner.nextLine());

                            System.out.print("Carbs: ");
                            int carbs = Integer.valueOf(this.scanner.nextLine());

                            int currentCalories = this.community.getPerson(name).getFoodJournal().getTotalCalories();
                            int maxCals = this.community.getPerson(name).getMaxCalories();

                            if (calories + currentCalories <= maxCals) {
                                this.community.getPerson(name).getFoodJournal().addToJournal(new FoodItem(foodName, calories, fat, protein, carbs));
                            } else {
                                System.out.println("");
                                System.out.println("Don't Eat This! --> You will exceed your daily limit");
                                System.out.print("If you would still like to consume " + foodName + " enter yes/no: "); 
                                String answer = this.scanner.nextLine();
                                if (answer.equals("yes")) {
                                    System.out.println(foodName + " has been added");
                                    this.community.getPerson(name).getFoodJournal().addToJournal(new FoodItem(foodName, calories, fat, protein, carbs));
                                } else if (answer.equals("no")) {
                                    System.out.println("Good Choice!");
                                } else {
                                    System.out.println("Not a valid input");
                                }
                            }
                        }

                        if (userCommand.equals("remove")) {
                            System.out.print("Food: ");
                            String foodToRemove = this.scanner.nextLine();                     
                            this.community.getPerson(name).getFoodJournal().removeFromJournal(foodToRemove);
                        }

                        if (userCommand.equals("stats")) {
                            System.out.println("--All Food--");
                            this.community.getPerson(name).getFoodJournal().printAllItems();                 
                            this.community.getPerson(name).getFoodJournal().printTotalStats();
                        }
                        
                        if (userCommand.equals("update")) {
                            System.out.println("Current Weight Is " + this.community.getPerson(name).getWeight());
                            System.out.print("Enter New Weight: ");
                            int newWeight = Integer.valueOf(this.scanner.nextLine());
                            this.community.getPerson(name).setWeight(newWeight);
                        }

                        if (userCommand.equals("exit")) {
                            break;
                        }
                    }
                } else {
                    System.out.println("Does Not Exist In The System!");
                }
            }
            
            if (command.equals("exit")) {
                break;
            }
        }
    }
            
    public boolean check(String name) {
        ArrayList<Person> people = this.community.getPeople();      
        for (Person human: people) {
            if (human.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public void add() {
        System.out.print("Name: ");
        String name = this.scanner.nextLine();
                
        System.out.print("Age: ");
        int age = Integer.valueOf(this.scanner.nextLine());
                
        System.out.print("Max Calories: ");
        int maxCalories = Integer.valueOf(this.scanner.nextLine());
                
        Person newPerson = new Person(name, age, maxCalories, new FoodJournal());
        this.community.addPersonToCommunity(newPerson);
    } 
    
    public void remove() {
        System.out.print("Name: ");
        String name = this.scanner.nextLine();
        this.community.removePerson(name);
    }
}
