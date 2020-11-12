package ru.job4j.tracker.profession;

import java.time.LocalDateTime;

public class Programmer extends Engineer {

    private LocalDateTime dedline;

    public LocalDateTime getDedline() {
        return dedline;
    }
}
