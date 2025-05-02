package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LimitedBuffer<T> {
    private final List<List<T>> buff = new ArrayList<>(MAX_ELEMENTS_PER_ROW);
    private final Supplier<T> T;

    private static final int MAX_ELEMENTS_PER_ROW = 5;
    public LimitedBuffer(int capacity, Supplier<T> T){
        init(capacity);
        this.T = T;
    }


    private void init(int cap){
        int rows = cap / MAX_ELEMENTS_PER_ROW;
        int last = cap % MAX_ELEMENTS_PER_ROW;

        for (int i = 0; i <rows ; i++) {
            List<T> row = new ArrayList<>(MAX_ELEMENTS_PER_ROW);
            for (int j = 0; j <MAX_ELEMENTS_PER_ROW ; j++) {
                row.add(T != null ? T.get() : null);
            }
            buff.add(row);
        }


        if (last > 0){
            List<T> last_row = new ArrayList<>(last);
            for (int i = 0; i <last ; i++) {
                last_row.add(T != null? T.get() : null);
            }
            buff.add(last_row);
        }

    }

    public List<List<T>> getBuff(){
        return this.buff;
    }


    public void addRow(T t){

    }
}
