package utils;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Random;

public class ProducerAndConsumer {
    private final LimitedBuffer buffer;
    private final Random random;
    private volatile boolean RUNNING;
    public ProducerAndConsumer(LimitedBuffer buffer) {
        this.buffer = buffer;
        random = new Random();
        RUNNING = true;
    }

    public void consume() {
        while (RUNNING) {
            buffer.add();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }




    public void stop(){
        RUNNING = false;
    }
    public void start(){
        RUNNING = true;
    }


}
