package org.example;


public class Main {
    public static void main(String[] args) {
        Box<Apple> apples1 = new Box<>();
        Box<Orange> oranges1 = new Box<>();
        Box<Orange> oranges2 = new Box<>();
        Apple apple=new Apple();
        Orange orange=new Orange();

        for (int i = 0; i < 30; i++) {
            apples1.add(apple);
            oranges2.add(orange);
        }
        for (int i = 0; i < 15; i++) {
            oranges1.add(orange);
        }
        System.out.printf("вес коробки № 1 - %.2f\nвес коробки № 2 - %.2f\n",
                          apples1.getWeight(),oranges1.getWeight());
        System.out.printf("вес коробки № 3 - %.2f\n",oranges2.getWeight());
        System.out.println("Вес коробок одинаков? "+oranges1.compare(apples1));
        System.out.println("Вес коробок одинаков? "+oranges1.compare(oranges2));
        System.out.println("Пересыпаем фрукты из одной коробки в другую:");
        oranges1.moveFruit(oranges2);

    }
}

