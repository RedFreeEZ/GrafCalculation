package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MainFormController {
    @FXML private Pane titlePane;
    private double x,y;
    @FXML private Label lblResults;
    private double num1 = 0;
    private String operator ="+";


    @FXML
    public void onNumberClicked(javafx.scene.input.MouseEvent mouseEvent) {
        int value = Integer.parseInt(((Pane)mouseEvent.getSource()).getId().replace("btn",""));
        lblResults.setText(Double.parseDouble(lblResults.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(lblResults.getText())*10+value));

    }
    @FXML
    public void onSymbolClicked(javafx.scene.input.MouseEvent mouseEvent) {
        String symbol = ((Pane)mouseEvent.getSource()).getId().replace("btn","");
        if (symbol.equals("Equals")){
            double num2 = Double.parseDouble(lblResults.getText());
            switch (operator){
                case "+" -> lblResults.setText((num1+num2) + "");
                case "-" -> lblResults.setText((num1-num2) + "");
                case "*" -> lblResults.setText((num1*num2) + "");
                case "/" -> lblResults.setText((num1/num2) + "");
            }
            operator=".";
        }
        else if(symbol.equals("Clear")){
            lblResults.setText(String.valueOf(0.0));
            operator=".";
        }
        else{
            switch (symbol){
                case "Plus" -> operator ="+";
                case "Minus" -> operator ="-";
                case "Multi" -> operator ="*";
                case "Divide" -> operator ="/";
            }
            num1 = Double.parseDouble(lblResults.getText());
            lblResults.setText(String.valueOf(0.0));
        }

    }
}

