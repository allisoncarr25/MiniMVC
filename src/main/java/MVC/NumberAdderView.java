package MVC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class NumberAdderView extends VBox {

    @FXML
    private TextField numberField1;
    @FXML
    private TextField numberField2;
    @FXML
    private Button addButton;
    @FXML
    private Label resultLabel;

    public NumberAdderView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NumberAdder.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    // Getter methods for UI pieces
    public TextField getNumberField1() {
        return numberField1;
    }

    public TextField getNumberField2() {
        return numberField2;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Label getResultLabel() {
        return resultLabel;
    }
}
