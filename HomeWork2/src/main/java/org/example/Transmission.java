package org.example;

public abstract class Transmission extends StateParameters{
    protected int grNumber;
    @Override
    public void start() {
        msg="Запуск трансмиссии";
        super.start();
    }
    @Override
    public void stop() {
        msg="Отключение трансмиссии";
        super.stop();
    }
    public int getGrNumber() {
        return grNumber;
    }
}
