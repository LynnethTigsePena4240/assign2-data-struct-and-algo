/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assign2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lynne
 */
public class Assign2 extends Application{
    
    @Override
    public void start(Stage stage){
        
        VBox vbox = new VBox();
        
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
