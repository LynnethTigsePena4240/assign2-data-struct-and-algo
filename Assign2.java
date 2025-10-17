package assign2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox; 
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Toggle;
import javafx.scene.control.Alert; 
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 *
 * @author lynne
 */
public class Assign2 extends Application {

    @Override
    public void start(Stage stage) {

        Label lname = new Label("Name:");
        TextField name = new TextField();

        Label lphone = new Label("Phone Number:");
        TextField phone = new TextField();

        Label lcake_type = new Label("Choose Cake Type");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Apple", "Carrot", "Cheesecake", "Chocolate", "Coffee", "Opera", "Tiramisu");
        comboBox.setPromptText("Select one");

        Label lcake_size = new Label("Choose Cake Size");

        ToggleGroup sizeGroup = new ToggleGroup();
        RadioButton smallRadio = new RadioButton("Small");
        RadioButton mediumRadio = new RadioButton("Medium");
        RadioButton largeRadio = new RadioButton("Large");

        smallRadio.setToggleGroup(sizeGroup);
        mediumRadio.setToggleGroup(sizeGroup);
        largeRadio.setToggleGroup(sizeGroup);

        HBox sizeBox = new HBox(10, smallRadio, mediumRadio, largeRadio);

        CheckBox deliveryCheck = new CheckBox("Customer lives within free delivery area");

        deliveryCheck.setOnAction(e -> {
            if (deliveryCheck.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Free Delivery Area");
                alert.setHeaderText(null);
                alert.setContentText("Customer is within the free delivery area!");
                alert.showAndWait();
            }
        });

        Button quitBtn = new Button("Quit");
        quitBtn.setStyle("-fx-background-color: #add8e6;");

        quitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                stage.close();
            }
        });

        Button saveBtn = new Button("Save");
        saveBtn.setStyle("-fx-background-color: #add8e6;");
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Read user inputs
                String customerName = name.getText().trim();
                String phoneNumber = phone.getText().trim();
                String cakeType = comboBox.getValue();
                Toggle selectedSize = sizeGroup.getSelectedToggle();
                String cakeSize = (selectedSize == null) ? null : ((RadioButton) selectedSize).getText();
                boolean freeDelivery = deliveryCheck.isSelected();

                // Validate inputs
                if (customerName.isEmpty() || phoneNumber.isEmpty() || cakeType == null || cakeSize == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Missing Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill out all fields before saving.");
                    alert.showAndWait();
                    return;
                }

                // Create order text
                String deliveryText = freeDelivery ? "Yes" : "No";
                String orderLine = customerName + " | " + phoneNumber + " | " + cakeType + " | " + cakeSize + " | Delivery: " + deliveryText;

                // Save to Orders.txt
                try (FileWriter fw = new FileWriter("Orders.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println(orderLine);

                    // Order saved alert
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Saved");
                    alert.setHeaderText(null);
                    alert.setContentText("Order saved to Orders.txt!");
                    alert.showAndWait();

                    // Resets form for next order
                    name.clear();
                    phone.clear();
                    comboBox.getSelectionModel().clearSelection();
                    sizeGroup.selectToggle(null);
                    deliveryCheck.setSelected(false);

                } catch (IOException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Failed to save the order file.");
                    alert.showAndWait();
                    e.printStackTrace();
                }
            }
        });

        HBox hname = new HBox(15, lname, name);
        HBox hphone = new HBox(15, lphone, phone);

        HBox btnBox = new HBox(10, quitBtn, saveBtn);

        VBox vbox = new VBox(15, hname, hphone, lcake_type, comboBox, lcake_size, sizeBox, deliveryCheck, btnBox);
        vbox.setPadding(new Insets(15, 12, 13, 14));

        Scene scene = new Scene(vbox, 400, 320);

        stage.setScene(scene);
        stage.setTitle("Bakery: Customers' Orders");
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
