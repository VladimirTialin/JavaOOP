package org.example.Steering;

public abstract class Steering{
    protected boolean work;
    public void on() {
        this.work=true;
        System.out.println("Рулевое управление включено");
        onControl();

}
    public void off(){
        this.work=false;
        System.out.println("Рулевое управление выключено");
        offControl();
    }

    protected abstract void onControl();
    protected abstract void offControl();
}
