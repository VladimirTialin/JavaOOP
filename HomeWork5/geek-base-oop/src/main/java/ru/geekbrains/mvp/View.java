package ru.geekbrains.mvp;

public interface View {

    int getValue(String message);

    void print(String message);
    default void printDiv(double div){
    }
    int getOperation(String message);
}
