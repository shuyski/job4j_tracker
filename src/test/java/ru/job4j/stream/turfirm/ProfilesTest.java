package ru.job4j.stream.turfirm;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Address> adr = new ArrayList<>();

    @Before
    public void setAdr() {
        adr.add(new Address("Moscow", "Bygrova", 15, 6));
        adr.add(new Address("Sochi", "Mihalkova", 4, 9));
        adr.add(new Address("Moscow", "Bygrova", 15, 6));
        adr.add(new Address("Sochi", "Mihalkova", 4, 9));
        adr.add(new Address("Novosibirsk", "Dyatlova", 8, 15));
        adr.add(new Address("Samara", "Novogilova", 9, 1));
    }

    @Test
    public  void list() {
        Profiles profiles = new Profiles();
        Profile prof = new Profile(adr.get(0));
        List<Profile> profile = new ArrayList<>();
        profile.add(prof);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Bygrova", 15, 6));
        assertThat(profiles.collect(profile), is(expected));
    }

    @Test
    public  void listSort() {
        Profiles profiles = new Profiles();
        List<Profile> profile = new ArrayList<>();
        Profile prof;
        for (Address list : adr) {
            prof = new Profile(list);
            profile.add(prof);
        }
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Bygrova", 15, 6));
        expected.add(new Address("Novosibirsk", "Dyatlova", 8, 15));
        expected.add(new Address("Samara", "Novogilova", 9, 1));
        expected.add(new Address("Sochi", "Mihalkova", 4, 9));
        assertThat(profiles.collect(profile), is(expected));
    }
}