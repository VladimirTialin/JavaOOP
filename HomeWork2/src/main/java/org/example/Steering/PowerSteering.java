package org.example.Steering;

public class PowerSteering extends Steering implements Blocking {
    private boolean PressureRegulatorPump;

        public boolean isPressureRegulatorPump() {
            return this.PressureRegulatorPump=false;
        }

        @Override
        public void toBlocking() {
            if(isPressureRegulatorPump()==true){
                System.out.println("Гидроусилитель разблокирован");
                onControl();
            }
        else System.out.println("Гидроусилитель заблокирован");
        }

    @Override
    protected void onControl() {
        System.out.println("ГУР вкл");
    }
    @Override
    protected void offControl() {
        System.out.println("ГУР выкл");
    }
}
