package stages;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import utils.Buffer;

import java.util.concurrent.atomic.AtomicInteger;

public class InitializerStage {
    private Buffer<?> buffer;
    private RunningStage runningStage = new RunningStage();
    private final double containerHeight = 650;
    private final double containerWidth = 1100;


    private final String sliderStyle = "-fx-min-width: 400px;" +
            "-fx-min-height: 200px;" +
            "-fx-font-size: 20px;";
    private final String labelStyle = "-fx-font-size: 40px;";

    private final String buttonStyle = " -fx-background-color: #000;"
            + "-fx-min-width: 200px;"
            + "-fx-min-height: 100px;"
            + "-fx-text-fill: #fff;"
            + "-fx-font-size: 26px;";
    private final String hoverStyle = buttonStyle +
            "-fx-background-color: #fff;" +
            "-fx-text-fill: #000;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0.5, 0, 0);";

    public void initialize(Stage stage) {
        String labelText = "Escolha o capacidade da fila/buffer: ";
        AtomicInteger capacity = new AtomicInteger(5);
        AnchorPane root = new AnchorPane();
        root.setPrefSize(containerWidth, containerHeight);
        Scene scene = new Scene(root);

        Slider slider = getSlider();
        Label label = new Label(labelText);
        Button initialize = getInitialize(capacity,stage);

        AnchorPane.setLeftAnchor(slider, (containerWidth - 410) / 2);
        AnchorPane.setTopAnchor(slider, (containerHeight - 200) / 2);

        AnchorPane.setLeftAnchor(label, (containerWidth - 650) / 2);
        AnchorPane.setTopAnchor(label, (containerHeight - 400) / 2);

        AnchorPane.setTopAnchor(initialize, (containerHeight - 200));
        AnchorPane.setLeftAnchor(initialize, (containerWidth - 250) / 2);

        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            capacity.set(newValue.intValue());
            label.setText(labelText + capacity.get());

        });
        label.setStyle(labelStyle);

        root.getChildren().addAll(label, initialize, slider);

        stage.setScene(scene);
        stage.show();
    }

    private Button getInitialize(AtomicInteger capacity,Stage stage) {
        Button initialize = new Button("Clique para Iniciar");
        initialize.setStyle(buttonStyle);
        initialize.setOnMouseEntered(e -> {
            initialize.setStyle(hoverStyle);
        });
        initialize.setOnMouseExited(e -> {
            initialize.setStyle(buttonStyle);
        });
        initialize.setOnAction(e -> {
           buffer = new Buffer<>(capacity.get());
            Window window = stage.getScene().getWindow();
            runningStage.run((Stage) window,capacity.get());
        });
        return initialize;
    }


    private Slider getSlider() {
        Slider slider = new Slider(5, 20, 1);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setStyle(sliderStyle);
        return slider;
    }


}
