
public class ManualTransmission extends Transmission {
    private int firstGear;
    private int secondGear;
    private int thirdGear;
    private int fourthGear;
    private int fifthGear;
    private int neutral;
    private int reverseGear;
    public int getFirstGear() {
        return 1;
    }
    public int getSecondGear() {
        return 2;
    }
    public int getThirdGear() {
        return 3;
    }
    public int getFourthGear() {
        return 4;
    }
    public int getFifthGear() {
        return 5;
    }
    public int getNeutral() {
        return 0;
    }
    public int getReverseGear() {
        return -1;
    }
    public void switchGear(int number){
        grNumber=number;
        if(number==getNeutral()) System.out.println("Включена нейтральная передача");
        else if (number==getReverseGear()) System.out.println("Включена задняя передача");
        else System.out.printf("Включена %d передача%n", number);
    }
    public boolean status(){
        if(getGrNumber() == getNeutral()) return true;
        else return  false;
    }
}

