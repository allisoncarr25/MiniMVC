import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Model class
class NumberModel {
    private int number1;
    private int number2;

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    // Method to add two numbers
    public int addNumbers() {
        return number1 + number2;
    }
}

// View class
class NumberView extends VBox {
    private TextField numberField1;
    private TextField numberField2;
    private Button addButton;
    private Label resultLabel;

    // Constructor to initialize UI parts
    public NumberView() {
        numberField1 = new TextField();
        numberField2 = new TextField();
        addButton = new Button("Add");
        resultLabel = new Label();

        // Adding UI parts to the layout
        getChildren().addAll(numberField1, numberField2, addButton, resultLabel);
    }

    // Getter methods for UI parts
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

// Controller class
class NumberController {
	
    // Constructor to initialize the model and view, and set event handler for the button
    public NumberController(NumberModel model, NumberView view) {
    	
        // Event handler for the button
        view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
                // Get numbers from text fields
                int num1 = Integer.parseInt(view.getNumberField1().getText());
                int num2 = Integer.parseInt(view.getNumberField2().getText());

                // Set numbers in the model
                model.setNumber1(num1);
                model.setNumber2(num2);

                // Perform addition and update result label
                int result = model.addNumbers();
                view.getResultLabel().setText("Result: " + result);
            }
        });
    }
}

// Main application class
public class NumberAdderMVC extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create model, view, and controller
        NumberModel model = new NumberModel();
        NumberView view = new NumberView();
        new NumberController(model, view);

        // Create scene with view
        Scene scene = new Scene(view, 300, 200);

        // Set stage title and scene, then show stage
        primaryStage.setTitle("Number Adder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
