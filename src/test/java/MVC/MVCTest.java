package MVC;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;

import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import MVC.NumberAdderApp;

import org.testfx.assertions.api.Assertions;

@ExtendWith(ApplicationExtension.class)
public class MVCTest extends ApplicationTest {

    @Start
    public void start(Stage stage) {
        Platform.runLater(() -> {
            try {
                new NumberAdderApp().start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testAddition(FxRobot robot) {
        // Type numbers into text fields
        robot.clickOn("#numberField1");
        robot.write("10");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        robot.clickOn("#numberField2");
        robot.write("20");

        // Click the add button
        robot.clickOn("#addButton");

        // Verify that result label displays correct result
        //verifyThat("#resultLabel", hasText("Result: 30"));
        Assertions.assertThat(robot.lookup("#resultLabel")
        		.queryAs(Label.class)).hasText("Result: 30");
    }

    @Test
    public void testInvalidInput(FxRobot robot) {
        // Type invalid input (non-numeric) into text fields
        robot.clickOn("#numberField1");
        robot.write("abc");
        robot.clickOn("#numberField2");
        robot.write("def");

        // Click the add button
        robot.clickOn("#addButton");

        // Verify that result label remains empty
        //verifyThat("#resultLabel", hasText(""));
        Assertions.assertThat(robot.lookup("#resultLabel")
        		.queryAs(Label.class)).hasText("Invalid input!");
    }
}
