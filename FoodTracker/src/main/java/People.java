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

public class People {
    private ArrayList<Person> people;
    
    public People() {
        this.people = new ArrayList<>();
    }
    
    public ArrayList<Person> getPeople() {
        return this.people;
    }
    
    public Person getPerson(String person) {
        Person searchPerson = people.get(0);
        for (Person human: this.people) {
            if (human.getName().equals(person)) {
                searchPerson = human;
            }
        }
        return searchPerson;
    }
    
    public void removePerson(String person) {
        Person toRemove = this.people.get(0);
        for (Person human: this.people) {
            if (human.getName().equals(person)) {
                toRemove = human;
            }
        }
        this.people.remove(toRemove);
    }
    
    public void addPersonToCommunity(Person person) { 
        this.people.add(person);
    }
}
