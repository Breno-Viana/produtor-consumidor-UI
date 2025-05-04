package utils;

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

}
