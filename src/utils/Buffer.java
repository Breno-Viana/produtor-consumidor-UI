package utils;


public class Buffer<T> {
    private T[][] buffer;

    public Buffer(int size) {
        INITIALIZE(size);
    }

    private void INITIALIZE(int size) {
        int rows = size / 5;

    }

    public T get(int x, int y) {
        return buffer[x][y];
    }

    public T[][] getBuffer() {
        return buffer;
    }
}
