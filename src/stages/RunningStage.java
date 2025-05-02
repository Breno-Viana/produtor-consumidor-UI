package stages;

import imgs.Images;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utils.LimitedBuffer;


public class RunningStage {
    private LimitedBuffer<ImageView> buffer;
    private static final int ELEMENTS_PER_ROW = 5;
    private static final int IMAGE_SIZE = 80;
    private static final int H_GAP = 130;
    private static final int V_GAP = 30;
    private static final int H_SIZE = 1300;
    private static final int V_SIZE = 850;
    private static final int CABINET_H = 400;
    private static final int CABINET_W = 900;

    public void run(Stage stage, int capacity) {
        buffer = setBuffer(capacity);
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: rgba(124,124,245,0.76)");


        GridPane grid = new GridPane();
        grid.setHgap(H_GAP);
        grid.setVgap(V_GAP);
        grid.setMinWidth(CABINET_W);
        grid.setMinHeight(CABINET_H);
        grid.setStyle("-fx-background-color: rgba(59,59,59,0.31);");
        populate(grid);
        AnchorPane.setLeftAnchor(grid, (double) 380 / 2);
        AnchorPane.setTopAnchor(grid, 160.0);

        //  System.out.println(grid.getWidth());
        root.getChildren().addAll(grid);
        stage.setScene(new Scene(root, H_SIZE, V_SIZE));
        stage.centerOnScreen();
        stage.show();
    }

    private LimitedBuffer<ImageView> setBuffer(int capacity) {
        return new LimitedBuffer<>(capacity, () -> {
            ImageView imageView = new ImageView();
            imageView.setFitHeight(IMAGE_SIZE);
            imageView.setFitWidth(IMAGE_SIZE);
            imageView.setPreserveRatio(true);
            return imageView;
        });
    }

    void populate(GridPane grid) {
        //  System.out.println(buffer.getBuff().size());
        for (int i = 0; i < buffer.getBuff().size(); i++) {
            for (int j = 0; j < buffer.getBuff().get(i).size(); j++) {
                ImageView iv = new ImageView();
                iv.setFitWidth(IMAGE_SIZE);
                iv.setFitHeight(IMAGE_SIZE);
                iv.setImage(Images.GET_EMPTY());
                grid.add(iv, j, i);
            }
        }
    }


    void add(GridPane grid, int row, int col) {
        System.out.println(buffer.getBuff().size());
        // if (buffer.getBuff().size() < row) return;

        ImageView view = new ImageView(Images.GET_BOX());
        view.setFitWidth(IMAGE_SIZE);
        view.setFitHeight(IMAGE_SIZE);
        grid.add(view, col, row);
    }

}

