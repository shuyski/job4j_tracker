package ru.job4j.tracker.profession;

public class Engineer extends Profession {
    private int experience; // стаж
    private String specialty; // специальность
    private int cash;

    public int getExperience() {
        return experience;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getCash() {
        return cash;
    }
}
