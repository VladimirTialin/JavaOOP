package org.example.Steering;

public class ElectricPowerSteering extends Steering implements Blocking{
    private boolean electroMotor;
    private boolean electroUnit;
    private  boolean contactlessSensor;

    public boolean ServiceAbility(){
        this.contactlessSensor=true;
        this.electroUnit=true;
        this.electroMotor=true;
        if((contactlessSensor & electroUnit & electroMotor)==true) return true;
        else return false;
    }
    @Override
    public void toBlocking() {
        if(ServiceAbility()==true){
            System.out.println("Электроусилитель разблокирован");
            onControl();
            }
        else System.out.println("Электроусилитель заблокирован");
    }

    @Override
    public void onControl() {
        System.out.println("ЭУР вкл");
    }
    @Override
    public void offControl() {
        System.out.println("ЭУР выкл");
    }
}
