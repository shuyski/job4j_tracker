package ru.job4j.tracker.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
         another.load = this.load + another.load;
         this.load = 0;
    }

    public static void main(String[] args) {
        Battery one = new Battery(79);
        Battery second = new Battery(21);
        System.out.println("Было: one = " + one.load + "% second = " + second.load + "%");
        one.exchange(second);
        System.out.println("Стало: one = " + one.load + "% second = " + second.load + "%");
    }
}
