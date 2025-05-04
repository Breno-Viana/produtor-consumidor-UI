package utils;


import imgs.Images;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LimitedBuffer extends GridPane {
    private static final int MAX_ELEMENTS_PER_ROW = 5;
    private final int CAPACITY;
    private final int ROWS;
    private final int COLS = MAX_ELEMENTS_PER_ROW;
    private static final int IMAGE_SIZE = 80;
    private static final int H_GAP = 130;
    private static final int V_GAP = 30;


    private final ImageView[][] buffSlots;

    public LimitedBuffer(int capacity) {
        ROWS = capacity / MAX_ELEMENTS_PER_ROW;
        buffSlots = new ImageView[ROWS][COLS];
        CAPACITY = capacity;
        setHgap(H_GAP);
        setVgap(V_GAP);
       // setGridLinesVisible(true);
        initializeEmptySlots();
    }

    private void initializeEmptySlots() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                buffSlots[i][j] = generateEmpty();
                add(buffSlots[i][j], j, i);
            }
        }
    }

    public boolean add() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (isSlotEmpty(i, j)) return add(i, j);
            }
        }
        return false;
    }

    public boolean add(int row, int col) {
        if (isPositionValid(row, col) && !isFull()) {
            if (isSlotEmpty(row, col)) {
                ImageView node = generate();
                node.setId("box");
                buffSlots[row][col] = node;
                add(node, col, row);
                return true;
            }
        }
        return false;
    }

    public boolean remove() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (!isSlotEmpty(i, j)) return remove(i, j);
            }
        }
        return false;
    }

    public boolean remove(int row, int col) {
        if (isPositionValid(row, col) && !isSlotEmpty(row, col)) {
            getChildren().remove(buffSlots[row][col]);

            ImageView empty = generateEmpty();
            buffSlots[row][col] = empty;
            add(empty, col, row);
            return true;
        }
        return false;
    }


    public boolean isSlotEmpty(int row, int col) {
        if (buffSlots[row][col] == null) {
            return true;
        }
        ImageView iv = buffSlots[row][col];
        return iv.getId().equalsIgnoreCase("empty");
    }

    public int getSize() {
        int count = 0;
        for (int i = 0; i < buffSlots.length; i++) {
            for (int j = 0; j < buffSlots[i].length; j++) {
                if (!isSlotEmpty(i, j)) count++;
            }
        }
        return count;
    }

    public boolean isFull() {
        return getSize() == CAPACITY;
    }


    private ImageView generate() {
        ImageView node = new ImageView();
        node.setFitWidth(IMAGE_SIZE);
        node.setFitHeight(IMAGE_SIZE);
        node.setImage(Images.GET_BOX());
        return node;
    }

    private ImageView generateEmpty() {
        ImageView iv = new ImageView();
        iv.setFitHeight(IMAGE_SIZE);
        iv.setFitWidth(IMAGE_SIZE);
        iv.setImage(Images.GET_VOID());
        iv.setId("empty");
        return iv;
    }

    public ImageView[][] getBuffSlots() {
        return this.buffSlots;
    }

    private boolean isPositionValid(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    public double getPositionX(int row, int col) {
        ImageView imageView = buffSlots[row][col];
        Bounds bounds = imageView.localToScene(imageView.getBoundsInLocal());
        return bounds.getMinX();

    }

    public double getPositionY(int row, int col) {
        ImageView imageView = buffSlots[row][col];
        Bounds bounds = imageView.localToScene(imageView.getBoundsInLocal());
        return bounds.getMinY();
    }
}

