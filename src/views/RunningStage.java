package views;


import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.LimitedBuffer;
import utils.ProducerAndConsumer;


public class RunningStage {
    private LimitedBuffer buffer;
    private static final int H_SIZE = 1300;
    private static final int V_SIZE = 850;
    private static final int CABINET_H = 400;
    private static final int CABINET_W = 900;

    public void run(Stage stage, int capacity) {
        buffer = new LimitedBuffer(capacity);

        all();
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: rgba(124,124,245,0.76)");


        StackPane cabinet = new StackPane();
        cabinet.getChildren().add(buffer);
        cabinet.setMinWidth(CABINET_W);
        cabinet.setMinHeight(CABINET_H);
        cabinet.setStyle("-fx-background-color: rgba(59,59,59,0.31);");
        AnchorPane.setLeftAnchor(cabinet, (double) 380 / 2);
        AnchorPane.setTopAnchor(cabinet, 160.0);


        Label state = new Label("Running");
        state.setStyle("-fx-font-size: 40px;" +
                "-fx-text-fill: #000");


        AnchorPane.setLeftAnchor(state, (double)(H_SIZE-120)/ 2);
        AnchorPane.setTopAnchor(state, 30.0);

        Button stop = new Button("Stop");
        stop.setStyle("-fx-font-size: 20px;");




        root.getChildren().addAll(state,stop,cabinet);
        stage.setScene(new Scene(root, H_SIZE, V_SIZE));
        stage.centerOnScreen();
        stage.show();


    }

    void all() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buffer.add(i, j);
            }
        }
    }

}

