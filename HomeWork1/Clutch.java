
public class Clutch extends StateParameters{
    @Override
    public void start() {
        msg="Сцепление включено";
        super.start();
    }

    @Override
    public void stop() {
        msg="Сцепление выключено";
        super.stop();
    }

    @Override
    public boolean getStatus() {
        return super.getStatus();
    }

}
