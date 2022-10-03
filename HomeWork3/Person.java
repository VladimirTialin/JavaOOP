package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Person implements Comparable<Person> {
    protected String name;
    protected int age;
    protected int weight;
    protected int height;

    public Person(String name, int age, int weight, int height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "name: " + name +
                " age:" + age +
                " weight: " + weight +
                " height:" + height +
                "\n";
    }

    @Override
    public int compareTo(Person o) {
        if(this.name.compareTo(o.name)==0){
            if(this.age>o.age) return 1;
            else if (this.age==o.age) return 0;
            else return -1;
        }
        return this.age;
    }

    public static void main(String[] args) {
        ArrayList<Person> person=new ArrayList<>();
        person.add(new Person("Иван",18,59,171));
        person.add(new Person("Сергей",20,45,155));
        person.add(new Person("Петр",23,88,180));
        person.add(new Person("Владимир",21,55,155));
        person.add(new Person("Лев",15,76,177));
        person.add(new Person("Андрей",65,100,168));
        Comparator name=new sortName();
        Comparator reverseWeight=new reverseWeight();
        Comparator height=new sortHeight();
        Comparator reverseAge=new reverseAge();
        Comparator reverseName=new reverseName();
        System.out.println("Не сортированный список");
        System.out.println(person);
        System.out.println("Сортировка по имени ");
        Collections.sort(person,name);
        System.out.println(person);
        System.out.println("Сортировка по имени на убывание");
        Collections.sort(person,reverseName);
        System.out.println(person);
        System.out.println("Сортировка по возрасту на убывание");
        Collections.sort(person,reverseAge);
        System.out.println(person);
        System.out.println("Сортировка по росту");
        Collections.sort(person,height);
        System.out.println(person);
        System.out.println("Сортировка по весу на убывание");
        Collections.sort(person,reverseWeight);
        System.out.println(person);

//        person.sort((o1, o2) -> Integer.compare(o1.height,o2.height));
//        {
//
//            System.out.println(person);
//        }

    }
}

class sortHeight implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        if(a.height<b.height) return -1;
        else if(a.height>b.height)return 1;
        else return 0;
    }
}
class sortName implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.name.compareToIgnoreCase(b.name);
    }
}
class reverseWeight implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.weight>b.weight? -1: a.weight<b.weight? 1: 0;
    }
}

class reverseAge implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.age>b.age? -1: a.age<b.age? 1: 0;
    }
}
class reverseName implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return b.name.compareToIgnoreCase(a.name);
    }
}