package org.example;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class RandomNumbers implements Iterable<Integer> {
    private int min=0;
    private final int max;
    /**
     * Диапазон случайных чисел
     * @param min - минимальный значение
     * @param max - максимальное значение
     */
    public RandomNumbers(int min, int max) {
        this.min = min;
        this.max = max;
    }
    /**
     * Диапазон случайных чисел
     * @param max - максимальное значение
     */
    public RandomNumbers(int max) {
        this.max = max;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int count=min;
            @Override
            public boolean hasNext() {
                if(min>=max){
                    System.out.printf("Ошибка! min(%d) >= max(%d)",min,max);
                    return false;
                }
                return count<=max;
            }

            @Override
            public Integer next() {
                Random rnd=new Random();
                count++;
                return rnd.nextInt(min,max);
            }
        };
    }
    public static void main(String[] args) {
        RandomNumbers randomNumbers=new RandomNumbers(20);
        for (Integer rndNum : randomNumbers) {
            System.out.printf("%d ",rndNum);
        }
    }
}