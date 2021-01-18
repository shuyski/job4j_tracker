package ru.job4j.stream.turfirm;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> prof) {
        return prof.stream()
                .map(ad -> ad.getAddress())
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}

