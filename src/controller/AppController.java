package controller;

import com.mathworks.engine.MatlabEngine;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

public class AppController {

    @FXML private Label ioCurrent;
    @FXML private Label ioLast;

    private String matlabEval(String data){
      String result = "";
      try{
         MatlabEngine matlabEngine = MatlabEngine.startMatlab();
         StringWriter output = new StringWriter();
         matlabEngine.eval(data,output,null);
         result = output.toString().replace(" ","").replace("\n","")
                 .replace("ans=","");
      }catch(IllegalArgumentException | IllegalStateException | InterruptedException | ExecutionException e){
         return e.getMessage();
      }
      System.out.println(result);
      return result;
   }
    private void ioCurrentSizeChanger(){
        if (ioCurrent.getText().length() >= 30){
            ioCurrent.setStyle("-fx-font-size: 28.0");
        }
    }
    private void ioWriter(String functionName){
       Dialog dialog = new TextInputDialog("");
       dialog.setHeaderText(null);
       dialog.setContentText("Ingresa el valor a evaluar");
       Optional<String> result = dialog.showAndWait();
       if (result.get() != "" || result.get() != " "){
          ioCurrent.setText(ioCurrent.getText() + functionName + "(" + result.get() + ") ");
          ioCurrentSizeChanger();
       }
    }
    //----
    @FXML public void buttonM33Click(ActionEvent event) throws IOException{
        String[] rows = new String[3];
        String function = "plot([";
        for (int i = 0; i < 3; i++) {
            Dialog dialog = new TextInputDialog("");
            dialog.setHeaderText("Ingrese la fila #" + (i + 1));
            dialog.setContentText("Separe los valores por \",\" ");

            String result = ((Optional<String>) dialog.showAndWait()).get();
            if (!result.equals("") || !result.equals(" ")) {
                rows[i] = result.replace(",", " ");
                function += (i < 2) ? rows[i] + ";" : rows[i] + "])";
            }
        }
        matlabEval(function);
        ioCurrent.setText(matlabEval( function.replace("plot", "det")));

    }
    @FXML public void buttonSenClick(ActionEvent event) throws IOException{
        ioWriter("sin");
    }
    @FXML public void buttonLogClick(ActionEvent event) throws IOException{
       ioWriter("log");
    }
    @FXML public void buttonFactClick(ActionEvent event) throws IOException{
       ioWriter("factorial");
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
        ioWriter("plot");
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
