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
}