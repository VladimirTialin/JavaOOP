package org.example;

import org.example.Steering.*;
public class Base {
    private Engine engine;
    private Wheels wheel1;
    private Wheels wheel2;
    private Wheels wheel3;
    private Wheels wheel4;
    private ManualTransmission transmission;
    private Clutch clutch;
    private ElectricPowerSteering steering;

    public Base() {
       engine=new Engine();
       wheel1=new Wheels();
       wheel2=new Wheels();
       wheel3=new Wheels();
       wheel4=new Wheels();
       transmission= new ManualTransmission();
       clutch=new Clutch();
       steering=new ElectricPowerSteering();
   }
    public void start(){
        engine.start();
        if(steering.ServiceAbility()){
            steering.toBlocking();
            transmission.start();
            clutch.stop();
        }else
        {
            steering.toBlocking();
            steering.off();
            engine.stop();
        }
    }
    public void drive(){
        if (engine.getStatus()){
            transmission.switchGear(2);
            if(transmission.status() && clutch.getStatus()) transmission.warning();
            else if((transmission.status() && !clutch.getStatus())||
                    (!transmission.status() && !clutch.getStatus())){
                transmission.switchGear(-1);
                clutch.start();
                transmission.switchGear(0);
                clutch.stop();
                transmission.switchGear(1);
                clutch.start();
                engine.throttleUp(40);
                wheel1.rotate();
                wheel2.rotate();
                wheel3.rotate();
                wheel4.rotate();
                clutch.stop();
                transmission.switchGear(2);
                engine.throttleUp(50);
                clutch.start();
                clutch.stop();
                transmission.switchGear(3);
                engine.throttleUp(80);
                clutch.start();
                clutch.stop();;
                transmission.switchGear(0);
                engine.throttleUp(5);
                transmission.stop();

            }
        }
    }
    public void stop(){
        engine.stop();
    }

}
//@usharik
