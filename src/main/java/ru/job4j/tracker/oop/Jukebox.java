package ru.job4j.tracker.oop;

public class Jukebox {
    public void music(int position) {
     if (position == 1) {
         System.out.println("Пусть бегут неуклюже\n" +
                 "Пешеходы по лужам,\n" +
                 "А вода по асфальту рекой.\n" +
                 "И неясно прохожим\n" +
                 "В этот день непогожий,\n" +
                 "Почему я веселый такой.");
     }
     else {
         if (position == 2) {
             System.out.println("Крыши домов дрожат под тяжестью дней\n" +
                     "Небесный пастух пасёт облака\n" +
                     "Город стреляет в ночь дробью огней\n" +
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
