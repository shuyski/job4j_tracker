package ru.job4j.oop;


public class Transport {
    public static void main(String[] args) {
        Vehicle air = new Air();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] transport = new Vehicle[]{air, train, bus};
        for (Vehicle ma : transport) {
            ma.move();
        }
        for (Vehicle s : transport) {
            s.speed();
        }
    }
}
