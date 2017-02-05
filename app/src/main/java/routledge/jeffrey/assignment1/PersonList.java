package routledge.jeffrey.assignment1;

import java.util.ArrayList;

/**
 * Created by jeffreyroutledge on 2017-02-04.
 *
 * This is a singleton.
 */

public class PersonList {
    public static ArrayList<Person> person_list;

    public PersonList() {
        if (person_list == null) {
            person_list = new ArrayList<Person>();
        }
        //return person_list;
    }

    public static ArrayList<Person> getPerson_list() {
        return person_list;
    }

    public void delete_list(Person P){
        person_list.remove(P);
    }

    public void add_person(Person p) {
        person_list.add(p);
    }

    public ArrayList<Person> getList() {
        return person_list;
    }

    public Person getPerson(int index){
        return person_list.get(index);
    }
}