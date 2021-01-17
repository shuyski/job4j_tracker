package ru.job4j.stream.turfirm;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public List<Address> collect(List<Profile> prof) {
        return prof.stream().map(ad -> ad.address).collect(Collectors.toList());
    }
}
