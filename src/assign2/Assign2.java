/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assign2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        
        Label lcake_type = new Label("Choose Cake Type");
	ComboBox<String> comboBox = new ComboBox<>();
	comboBox.getItems().addAll("Apple", "Carrot", "Cheesecake", "Chocolate","Coffe","Opera","Tiramisu"); //this will return all of the choices in the comboBox
	comboBox.setPromptText("Select one");
        
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
        
        //Hboxs
        HBox hname = new HBox(15,lname,name);
        
        HBox btnBox = new HBox(10,quitBtn, saveBtn );
             
        VBox vbox = new VBox(15,hname,lcake_type ,comboBox, btnBox);
        vbox.setPadding(new Insets(15, 12, 13, 14));
        
        Scene scene = new Scene(vbox,400,200);
        
        stage.setScene(scene);
        stage.setTitle("Bakery: Customers’ Orders");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
