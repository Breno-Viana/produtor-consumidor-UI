import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.Buffer;
import utils.ProduceAndConsume;
import utils.Product;

public class Main extends Application {
    private static Buffer<Product> buffer;

    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
    }





    private static void initializeBuffer() {
        System.out.println("Inicializando Buffer...");
        int CAPACITY = 10;
        buffer = new Buffer<>(CAPACITY);
        System.out.println("Buffer carregado com a capacidade " + CAPACITY);
    }


}
