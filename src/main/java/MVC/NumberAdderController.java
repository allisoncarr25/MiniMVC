package MVC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NumberAdderController {
    @FXML
    private TextField numberField1;
    @FXML
    private TextField numberField2;
    @FXML
    private Label resultLabel;

    @FXML
    private void handleAddButtonAction(ActionEvent event) {
        try {
            int num1 = Integer.parseInt(numberField1.getText());
            int num2 = Integer.parseInt(numberField2.getText());
            int result = num1 + num2;
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input!");
        }
    }
}
