package org.example.Steering;

public class SteeringWithoutPower extends Steering implements Blocking {

        public boolean StartSteering(boolean engine){
            if(engine==true) {
                this.work=true;
                return true;
            }
            else{
                this.work=false;
                return false;
            }
        }

    @Override
    public void toBlocking() {
            if(work==true) {
                System.out.println("Руль разблокирован");
                onControl();
            }
            else {
                System.out.println("Руль заблокирован");
            offControl();
            }
    }

    @Override
    protected void onControl() {
        System.out.println("Руль вкл");
    }

    @Override
    protected void offControl() {
        System.out.println("Руль выкл");
    }
}
