package ru.job4j.tracker.oop;

public class Jukebox {
    public void music(int position) {
     if (position == 1) {
         System.out.println("Пусть бегут неуклюже" + System.lineSeparator() +
                 "Пешеходы по лужам," + System.lineSeparator() +
                 "А вода по асфальту рекой." + System.lineSeparator() +
                 "И неясно прохожим" + System.lineSeparator() +
                 "В этот день непогожий," + System.lineSeparator() +
                 "Почему я веселый такой.");
     }
     else {
         if (position == 2) {
             System.out.println("Крыши домов дрожат под тяжестью дней" + System.lineSeparator() +
                     "Небесный пастух пасёт облака" + System.lineSeparator() +
                     "Город стреляет в ночь дробью огней" + System.lineSeparator() +
                     "Но ночь сильней, её власть велика.");
         }
         else   {
             System.out.println("Песня не найдена");
         }
     }
    }

    public static void main(String[] args) {
      Jukebox song = new Jukebox();
        System.out.print("Если ввести 1:  ");
        song.music(1);
        System.out.println();
        System.out.print("Если ввести 2:  ");
        song.music(2);
        System.out.println();
        System.out.print("Если ввести другое число:  ");
        song.music(3);
        System.out.println();


    }
}
