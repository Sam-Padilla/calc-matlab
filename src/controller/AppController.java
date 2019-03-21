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
    private void ioSimpleWriter(String functionName, String text){
       Dialog dialog = new TextInputDialog("");
       dialog.setHeaderText(null);
       dialog.setContentText(text);
       Optional<String> result = dialog.showAndWait();
       if (result.get() != "" || result.get() != " "){
          ioCurrent.setText(ioCurrent.getText() + functionName + "(" + result.get() + ") ");
          ioCurrentSizeChanger();
       }
    }
    private String[] ioArrayResults(String[] rows){
        for (int i = 0; i < rows.length; i++) {
            Dialog dialog = new TextInputDialog("");
            dialog.setHeaderText(null);
            dialog.setContentText("Ingrese el valor de " + rows[i]);
            String result = ((Optional<String>) dialog.showAndWait()).get();
            if (!result.equals("") || !result.equals(" ")) {
                rows[i] = result;
            }
        }
        return rows;
    }
    //---- Group 1
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
        ioSimpleWriter("sin", "Ingresa el valor a evaluar");
    }
    @FXML public void buttonLogClick(ActionEvent event) throws IOException{
       ioSimpleWriter("log", "Ingresa el valor a evaluar");
    }
    @FXML public void buttonFactClick(ActionEvent event) throws IOException{
       ioSimpleWriter("factorial", "Ingresa el valor a evaluar");
    }
    //---- Group 2
    @FXML public void buttonESquaredClick(ActionEvent event) throws IOException{
        String[] rows = ioArrayResults(new String[]{"ax²","bx","c"});
        String function = "syms x; solve("+rows[0] + "*x^2+" + rows[1] + "*x+" + rows[2] + ")";
        ioCurrent.setText(matlabEval(function));
    }
    @FXML public void buttonSE2xClick(ActionEvent event) throws IOException{
        String[] rows = ioArrayResults(new String[]{"X1", "Y1", "Z1", "X2", "Y2", "Z2"});
        String function = "S = solve('" + rows[0]+"*x+" + rows[1] + "*y=" + rows[2] + "',"
                                  + "'" + rows[3]+"*x+" + rows[4] + "*y=" + rows[5] + "');"
                                  + "S = [S.x S.y]";
        String text = matlabEval(function);
        ioCurrent.setText(text.substring(text.indexOf("[")));
    }
    @FXML public void buttonIDefClick(ActionEvent event) throws IOException{
        String[] rows = ioArrayResults(new String[]{"la funcion","lim-", "lim+"});
        String function = "syms x; int("+rows[0] +",x," + rows[1] +"," + rows[2] + ")";
        ioCurrent.setText(matlabEval(function));
    }
    @FXML public void buttonnDClick(ActionEvent event) throws IOException{
        String[] rows = ioArrayResults(new String[]{"la funcion (x)","orden de derivada"});
        String function = "syms x; diff("+rows[0] +"," + rows[1] + ")";
        ioCurrent.setText(matlabEval(function));
    }
    //---- Group 3
    @FXML public void buttonMeClick(ActionEvent event) throws IOException{
        ioSimpleWriter("median", "Ingresa el array de datos a evaluar");
    }
    @FXML public void buttonDesvClick(ActionEvent event) throws IOException{
        ioSimpleWriter("std", "Ingresa el array de datos a evaluar");
    }
    @FXML public void buttonVariClick(ActionEvent event) throws IOException{
        ioSimpleWriter("var", "Ingresa el array de datos a evaluar");
    }
    @FXML public void buttonRLClick(ActionEvent event) throws IOException{
        String[] rows = ioArrayResults(new String[]{"Array X","Array Y"});
        String function = "scatter("+rows[0] +"," + rows[1] + ");" +
                          "line("+rows[0] +"," + rows[1] + ")";
        ioCurrent.setText(matlabEval(function));
    }
    //---- Group 4
    @FXML public void buttonSphClick(ActionEvent event) throws IOException{
        String[] rows = ioArrayResults(new String[]{"la altura","radio"});
        String function = "sphere("+rows[0] +"," + rows[1] + ")";
        ioCurrent.setText(matlabEval(function));
    }
    @FXML public void buttonLgClick(ActionEvent event) throws IOException{
        String[] rows = ioArrayResults(new String[]{"X","Y"});
        String function = "plot(linspace("+rows[0] +"," + rows[1] + "))";
        ioCurrent.setText(matlabEval(function));
    }
    @FXML public void buttonGRClick(ActionEvent event) throws IOException{
        ioSimpleWriter("plot", "Ingrese los puntos a graficar");
    }
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
