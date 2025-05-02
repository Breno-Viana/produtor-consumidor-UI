package stages;

import imgs.Images;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utils.Buffer;


public class RunningStage {
    private Buffer<ImageView> buffer;
    private static final int ELEMENTS_PER_ROW = 5;
    private static final int IMAGE_SIZE = 80;
    private static final int H_GAP = 130;
    private static final int V_GAP = 30;
    private static final int H_SIZE = 1300;
    private static final int V_SIZE = 850;

    public void run(Stage stage, int capacity) {
        buffer = setBuffer(capacity);
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: rgba(124,124,245,0.76)");



        GridPane grid = new GridPane();
        grid.setHgap(H_GAP);
        grid.setVgap(V_GAP);
        grid.setMinWidth(920);
        grid.setMinHeight(400);
        grid.setStyle("-fx-background-color: rgba(59,59,59,0.31);");
        populateGrid(grid,0,2);
        populateGrid(grid,2,2);
        populateGrid(grid,3,2);
        populateGrid(grid,4,2);



        AnchorPane.setLeftAnchor(grid,(double)380/2);
        AnchorPane.setTopAnchor(grid,160.0);
        System.out.println(grid.getWidth());
        root.getChildren().add(grid);
        stage.setScene(new Scene(root, H_SIZE, V_SIZE));
        stage.centerOnScreen();
        stage.show();
    }

    private Buffer<ImageView> setBuffer(int capacity) {
        return new Buffer<>(capacity, () -> {
            ImageView imageView = new ImageView();
            imageView.setFitHeight(IMAGE_SIZE);
            imageView.setFitWidth(IMAGE_SIZE);
            imageView.setPreserveRatio(true);
            return imageView;
        });
    }

    private void populateGrid(GridPane grid, int rowIndex,int colIndex) {
        int col = 0, row = 0;
        if(colIndex > ELEMENTS_PER_ROW || rowIndex > ELEMENTS_PER_ROW) return;
        for (int i = 0; i <buffer.getBuffer().size() ; i++) {
            for (int j = 0; j <buffer.getBuffer().get(i).size() ; j++) {
                ImageView poll = buffer.getBuffer().get(i).poll();
                poll.setImage(Images.GET_BOX());
                grid.add(poll,colIndex,rowIndex);
                col++;
                if (col>=ELEMENTS_PER_ROW){
                    col = 0;
                    row++;
                }
            }
        }
    }


}