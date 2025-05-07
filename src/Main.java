import javafx.application.Application;
import javafx.stage.Stage;
import views.PrimerStage;

public class Main extends Application {


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Produtor E Consumidor");
        PrimerStage.start(stage);

        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            stage.close();
            System.exit(0);
        });
    }
}