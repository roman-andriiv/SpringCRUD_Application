package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman_Andriiv
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Roman"));
        people.add(new Person(++PEOPLE_COUNT, "Alina"));
        people.add(new Person(++PEOPLE_COUNT, "Stella"));
        people.add(new Person(++PEOPLE_COUNT, "Ivan"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(final int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId()==id);
    }
}
