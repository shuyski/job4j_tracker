package ru.job4j.tracker.profession;

import java.time.LocalDateTime;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private LocalDateTime birthday;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }
}
