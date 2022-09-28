

public class Car extends StateParameters {
    private Doors frontRightDoor;
    private Doors frontLeftDoor;
    private Doors rearLeftDoor;
    private Doors rearRightDoor;
    private Trunk trunk;
    private CarHood carHood;

    public Car() {
        frontRightDoor = new Doors();
        frontLeftDoor = new Doors();
        rearLeftDoor = new Doors();
        rearRightDoor = new Doors();
        trunk = new Trunk();
        carHood=new CarHood();
    }

    public  boolean StatusOfElementCar() {
        if (frontRightDoor.getStatus() && frontLeftDoor.getStatus() &&
                rearRightDoor.getStatus() && rearLeftDoor.getStatus()&&
                trunk.getStatus()&& carHood.getStatus()) {
            return true;
        }
        return false;
    }
    public void status(){
        frontRightDoor.close("Передняя правая дверь закрыта");
        frontLeftDoor.close("Передняя левая дверь закрыта");
        rearRightDoor.close("Задняя правая дверь закрыта");
        rearLeftDoor.close("Задняя левая дверь закрыта");
        trunk.close("Багажник закрыт");
        carHood.close("Капот закрыт");
    }

    @Override
    public void warning() {
        super.warning();
    }
}
