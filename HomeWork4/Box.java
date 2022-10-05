package org.example;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public void add(T fruits) {
        box.add(fruits);
    }

    public double getWeight() {
        return box.isEmpty() ? 0 : this.box.size() * this.box.get(0).weight();
    }

    public int size() {
        return this.box.size();
    }
    /**
     * Метод compare сравнивает коробки по количеству находящихся в них фруктов
     * @param boxFruit - коробка для сравнения
     */
    public boolean compare(Box<? extends Fruit> boxFruit) {
        return this.getWeight() == boxFruit.getWeight();
    }

    /**
     * Перемещение фруктов из коробки в коробку
     * @param boxMoving - коробка, в которую перемещаются фрукты
     */
    public void moveFruit(Box<T> boxMoving) {
        while (box.iterator().hasNext()) {
            boxMoving.add(box.iterator().next());
            box.remove(box.iterator().next());
        }
        System.out.printf("коробка № 1 - %d\nкоробка № 2 - %d\n",box.size(),boxMoving.size());
    }
}
