package controller;


import com.mathworks.engine.MatlabEngine;
import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.ExecutionException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AppController {
    
   private String matlabEval(String data){
       String result = "";
       try{
           MatlabEngine matlabEngine = MatlabEngine.startMatlab();
           StringWriter output = new StringWriter();
           matlabEngine.eval(data,output,null);
       }catch(IllegalArgumentException | IllegalStateException | InterruptedException | ExecutionException e){
           return e.getMessage();
       }
       return result;
   }
    
    @FXML private Label ioCurrent;  
    @FXML private Label ioLast;
    
    @FXML public void buttonPPlusClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    @FXML public void buttonPMinusClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    @FXML public void buttonPMultipClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    @FXML public void buttonPDivisionClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    //----
    
    @FXML public void buttonEClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    @FXML public void buttonESquaredClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    @FXML public void buttonSE2xClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    @FXML public void buttonSE3xClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    //----
    
    @FXML public void buttonIClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    @FXML public void buttonIDefClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    @FXML public void buttonDClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    @FXML public void buttonDDefClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
    
    //----
    
    @FXML public void buttonUndefinedClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        System.out.println(button.getText() + "EN CONSTRUCCIÓN");
    }
    
    //@FXML public void buttonUndefinedClick(ActionEvent event) throws IOException{
    //    Button button = (Button) event.getSource();
    //    System.out.println(button.getText());
    //}
    
    //@FXML public void buttonUndefinedClick(ActionEvent event) throws IOException{
    //    Button button = (Button) event.getSource();
    //    System.out.println(button.getText());
    //}
    
        @FXML public void buttonPlusClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + " " + button.getText() + " ");
    }
    //----
   
    @FXML public void button7Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
    
    @FXML public void button4Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
    
    @FXML public void button1Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
    
    @FXML public void buttonMinusClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + " " + button.getText() + " ");
    }
    
    
    //----
    
    @FXML public void button8Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
    
    @FXML public void button5Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
    
    @FXML public void button2Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
    
    @FXML public void buttonMultiClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + " " + button.getText() + " ");
    }

    //----
    
    @FXML public void button9Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
    
    @FXML public void button6Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
    
    @FXML public void button3Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
    
    @FXML public void buttonDivisionClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + " " + button.getText() + " ");
    }
    
     //----
     @FXML public void button0Click(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
     
    @FXML public void buttonPointClick(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        ioCurrent.setText(ioCurrent.getText() + button.getText());
    }
        
    @FXML public void buttonCClick(ActionEvent event) throws IOException{
        ioCurrent.setText("");
        ioLast.setText("");
    }
    
     @FXML public void buttonEqualsClick(ActionEvent event) throws IOException{
        ioLast.setText(ioCurrent.getText());
        String result = matlabEval(ioCurrent.getText());
        ioCurrent.setText(result);
        
    }
}
