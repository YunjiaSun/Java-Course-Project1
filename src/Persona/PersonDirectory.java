/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {

    ArrayList<Person> personlist;

    public PersonDirectory() {
        personlist = new ArrayList<Person>();
    }

    public Person newPerson(String id, String name) {
        Person p = new Person(id, name);
        personlist.add(p);
        return p;
    }

    public Person findPerson(String id) {
        for (Person p : personlist) {
            if (p.isMatch(id)) {
                return p;
            }
        }
        return null; // not found after going through the whole list
    }

    public void printPersonDirectory() {
        for (Person p : personlist) {
            System.out.println(p);
        }
    }
}