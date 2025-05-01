import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import stages.InitializerStage;

public class Main extends Application {
    private final double containerHeight = 650;
    private final double containerWidth = 1100;
    private final InitializerStage initializerStage = new InitializerStage();
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

        Label ST = new Label("Podutor e Consumidor");
        Button startButton = getStartButton(stage);

        AnchorPane.setTopAnchor(startButton, (containerHeight-200));
        AnchorPane.setLeftAnchor(startButton, (containerWidth-200)/2);



        ST.setStyle(labelStyle);
        AnchorPane.setTopAnchor(ST, (containerHeight-200)/2);
        AnchorPane.setLeftAnchor(ST, (containerWidth-500)/2);


        root.getChildren().addAll(ST, startButton);
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    private Button getStartButton(Stage stage) {
        Button startButton = new Button("Start");
        startButton.setStyle(defaultButtonStyle);

        startButton.setOnMouseEntered(e ->{
            startButton.setStyle(hoverButtonStyle);
        });
        startButton.setOnMouseExited(e ->{
            startButton.setStyle(defaultButtonStyle);
        });

        startButton.setOnAction(e ->{
            Window window = stage.getScene().getWindow();
            initializerStage.initialize((Stage) window);
        }); return startButton;
    };




}
