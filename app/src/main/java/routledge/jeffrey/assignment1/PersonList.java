package routledge.jeffrey.assignment1;

import java.util.ArrayList;

/**
 * Created by jeffreyroutledge on 2017-02-04.
 *
 * This class is a singleton that holds the list of people's records.
 */
public class PersonList {
    public static ArrayList<Person> person_list;

    /**
     * If there is no PersonList, create one.
     */
    public PersonList() {
        if (person_list == null) {
            person_list = new ArrayList<Person>();
        }
    }

    /**
     * Deletes a Person from the PersonList
     *
     * @param P
     */
    public void deleteList(Person P){
        person_list.remove(P);
    }

    /**
     * Adds a person to the Person from the PersonList
     *
     * @param p
     */
    public void addPerson(Person p) {
        person_list.add(p);
    }

    /**
     * Returns the list.
     *
     * @return
     */
    public ArrayList<Person> getList() {
        return person_list;
    }

    /**
     * Gets the person at a specific index in the list.
     *
     * @param index
     * @return
     */
    public Person getPerson(int index){
        return person_list.get(index);
    }
}