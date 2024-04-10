package MVC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NumberAdderApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(NumberAdderApp.class.getResource("NumberAdder.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Number Adder");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
