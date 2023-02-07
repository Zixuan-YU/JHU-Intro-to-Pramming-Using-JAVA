import javafx.application.Application;
import javafx.geometry.Insets;
//import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {

        // creating textField for value1 and value2
        TextField textField1 = new TextField();

        TextField textField2 = new TextField();

        TextField textFieldSum = new TextField();

        // creating the Calculate Button
        Button button = new Button("Calculate");

        // Creating labels
        Label label1 = new Label("First Value: ");
        Label label2 = new Label("Second Value: ");
        Label labelSum = new Label("Sum is: ");

        // Setting the message with read data
        // Text text = new Text("");

        /*
         * // Displaying the message
         * button.setOnAction(e -> {
         * // Retrieving data
         * String value1 = textField1.getText();
         * String value2 = textField2.getText();
         * // String value2 = textField2.getText();
         * });
         */

        // Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // Adding labels and textFields
        grid.addRow(0, label1, textField1);
        grid.addRow(1, label2, textField2);
        grid.addRow(2, labelSum, textFieldSum);
        // Adding the calculate button
        grid.addColumn(1, button);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");

        primaryStage.show();

    }

    public static void main(String args[])
    {
        launch(args);
    }
}
