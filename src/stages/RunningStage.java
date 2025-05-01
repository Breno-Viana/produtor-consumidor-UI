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
    String[][] matriz = {
            {"A", "B", "C"},
            {"D", "E", "F"},
            {"G", "H", "I"}
    };


    public void run(Stage stage, int capacity) {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 1300, 850);
        GridPane grid = new GridPane();
        grid.setHgap(100);
        grid.setVgap(50);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                ImageView imageView = new ImageView();
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                imageView.setImage(Images.GET_BOX());
                grid.add(imageView, j, i);
            }
        }

        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();


    }
}