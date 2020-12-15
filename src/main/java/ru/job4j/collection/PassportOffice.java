package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        if (!citizens.isEmpty()) {
            for (String key : citizens.keySet()) {
                if (!citizen.getPassport().contains(key)) {
                    citizens.put(citizen.getPassport(), citizen);
                    return true;
                }
            }
        }
        else {
            citizens.put(citizen.getPassport(), citizen);
            }

        return false;
    }


    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}
