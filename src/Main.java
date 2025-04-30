import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Buffer;
import utils.ProduceAndConsume;

public class Main extends Application {
    private Buffer<?> buffer;
    private ProduceAndConsume PC;
    private final double containerHeight = 650;
    private final double containerWidth = 1100;

    private final String defaultButtonStyle = "-fx-background-color: #000;" +
            "-fx-min-width: 200px;" +
            "-fx-min-height: 100px;" +
            "-fx-text-fill: #fff;" +
            "-fx-font-size: 26px;";
    private final String hoverButtonStyle = defaultButtonStyle+"-fx-background-color:#fff;" +
            " -fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0.5, 0, 0);" +
            "-fx-text-fill: #000";

    private final String labelStyle = "-fx-text-fill:#000;" +
            "-fx-font-size: 50px";

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = new AnchorPane();

        Scene scene = new Scene(root, containerWidth, containerHeight);

        Button startButton = new Button("Start");
        //  startButton.setPrefSize(200, 100);

        startButton.getStyleClass().add("btn");
        startButton.setStyle(defaultButtonStyle);


        startButton.setOnMouseEntered(e ->{
            startButton.setStyle(hoverButtonStyle);
        });
        startButton.setOnMouseExited(e ->{
            startButton.setStyle(defaultButtonStyle);
        });
        //startButton.setLayoutX(450);
        //startButton.setLayoutY(450);


        startButton.setOnAction(event -> {
            System.out.println("Start");
        });

        AnchorPane.setTopAnchor(startButton, (containerHeight-200));
        AnchorPane.setLeftAnchor(startButton, (containerWidth-200)/2);

        root.getChildren().add(startButton);


        Label ST = new Label("Podutor e Consumidor");

        ST.setStyle(labelStyle);
        AnchorPane.setTopAnchor(ST, (containerHeight-200)/2);
        AnchorPane.setLeftAnchor(ST, (containerWidth-500)/2);
        root.getChildren().add(ST);


        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    private void initializeBuffer(int capacity) {
        System.out.println("Inicializando Buffer...");
        buffer = new Buffer<>(capacity);
        System.out.println("Buffer carregado com a capacidade " + capacity);
    }


}
