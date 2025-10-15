package assign2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lynne
 */
public class Assign2 extends Application{
    
    @Override
    public void start(Stage stage){
        
        Label lname = new Label("Name:");
        TextField name = new TextField();        
        
        Label lphone = new Label("Phone Number:");
        TextField phone = new TextField();
        
        Label lcake_type = new Label("Choose Cake Type");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Apple", "Carrot", "Cheesecake", "Chocolate","Coffee","Opera","Tiramisu");
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
        
        Button quitBtn = new Button("Quit");
        quitBtn.setStyle("-fx-background-color: #add8e6;");
        
        quitBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                stage.close();
            }
        });
        
        Button saveBtn = new Button("Save");
        saveBtn.setStyle("-fx-background-color: #add8e6;");
        
        HBox hname = new HBox(15, lname, name);
        HBox hphone = new HBox(15, lphone, phone);
        
        HBox btnBox = new HBox(10, quitBtn, saveBtn);
             
        VBox vbox = new VBox(15, hname, hphone, lcake_type, comboBox, lcake_size, sizeBox, btnBox);
        vbox.setPadding(new Insets(15, 12, 13, 14));
        
        Scene scene = new Scene(vbox, 400, 300);
        
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