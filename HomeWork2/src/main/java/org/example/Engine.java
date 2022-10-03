package org.example;

public class Engine extends StateParameters {
    @Override
    public void start() {
        msg="Двигатель запущен";
        super.start();
    }

    @Override
    public void stop() {
        msg="Двигатель остановлен";
        super.stop();
    }

    public void throttleUp(int level) {
        if (this.getStatus()) System.out.printf("Дросель открыт %d%% \n", level);

    }
}


