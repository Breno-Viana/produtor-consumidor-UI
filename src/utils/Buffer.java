package utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Supplier;

public class Buffer<T> {
    private final int ELEMENTS_PER_ROW = 5;
    private final List<Queue<T>> buffer = new ArrayList<>();
    private final Supplier<T> t;

    public Buffer(int size, Supplier<T> type) {
        this.t = type;
        INITIALIZE(size);
    }

    private void INITIALIZE(int size) {
        int rows = size / ELEMENTS_PER_ROW;
        int last_row = size % ELEMENTS_PER_ROW;


        for (int i = 0; i < rows; i++) {
            Queue<T> row = new ArrayBlockingQueue<>(ELEMENTS_PER_ROW);
            for (int j = 0; j < ELEMENTS_PER_ROW; j++) {
                row.add(t.get());
            }
            buffer.add(row);
        }

        if (last_row > 0) {
            Queue<T> last = new ArrayBlockingQueue<>(last_row);
            for (int i = 0; i < last_row; i++) {
                last.add(t.get());
            }
            buffer.add(last);
        }
    }

    public List<Queue<T>> getBuffer() {
        return buffer;
    }

    public int getQnt() {
        int R = 0;
        for (Queue<T> ls : buffer) {
            R += ls.size();
        }
        return R;
    }

    public int getRow(int i){
        return buffer.get(i).size();
    }
}
