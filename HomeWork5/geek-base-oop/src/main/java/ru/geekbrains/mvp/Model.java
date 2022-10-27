package ru.geekbrains.mvp;

public class Model {

    private int first;

    private int second;

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getSum() {
        return first + second;
    }
    public int getSub() {
        return first - second;
    }
    public int getMulti() {
        return first * second;
    }
    public double getDiv() {;
        if (second!=0) return first /(double)(second);
        else throw new RuntimeException("Делить на ноль нельзя!");
    }

    public static void main(String[] args) {
        Model model = new Model();

        model.setFirst(1);
        model.setSecond(1);
        if (model.getSum() != 2 || model.getSub() != 0 || model.getMulti() != 1 || model.getDiv() != 1.0) {
            throw new AssertionError("Incorrect test result");
        }

        model.setFirst(1);
        model.setSecond(2);
        if (model.getSum() != 3 || model.getSub() != -1 || model.getMulti() != 2 || model.getDiv() != 0.5)  {
            throw new AssertionError("Incorrect test result");
        }

        model.setFirst(2);
        model.setSecond(4);
        if (model.getSum() != 6 || model.getSub() != -2 || model.getMulti() != 8 || model.getDiv() != 0.5) {
            throw new AssertionError("Incorrect test result");
        }
    }
}
