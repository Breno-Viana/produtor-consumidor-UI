package utils;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Buffer<T> {
    private final Queue<T> BUFFER;
    private final int CAPACITY;

    public Buffer(int maxCapacity) {
        BUFFER = new ArrayBlockingQueue<>(maxCapacity);
        CAPACITY = maxCapacity;
    }

    public Queue<T> getBuffer() {
        return BUFFER;
    }

    public int getCapacity() {
        return CAPACITY;
    }


    public boolean isFull(){
        return BUFFER.size() == CAPACITY;
    }
}
