package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> filterName = (person) -> key.contains(person.getName());
        Predicate<Person> filterSurname = (person) -> key.contains(person.getSurname());
        Predicate<Person> filterPhone = (person) -> key.contains(person.getPhone());
        Predicate<Person> filterAddress = (person) -> key.contains(person.getAddress());
        var combine = filterName.or(filterSurname.or(filterPhone.or(filterAddress)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
