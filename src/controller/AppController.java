package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AppController {
       
     @FXML 
     public void button8Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
}
