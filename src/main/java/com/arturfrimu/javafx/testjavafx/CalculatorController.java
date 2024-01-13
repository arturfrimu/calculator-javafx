package com.arturfrimu.javafx.testjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField display;

    private long number1 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void handleNumber(javafx.event.ActionEvent event) {
        if (start) {
            display.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        display.setText(display.getText() + value);
    }

    @FXML
    private void handleOperator(javafx.event.ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Long.parseLong(display.getText());
            display.setText("");
        } else {
            if (operator.isEmpty())
                return;

            display.setText(String.valueOf(calculate(number1, Long.parseLong(display.getText()), operator)));
            operator = "";
            start = true;
        }
    }

    @FXML
    private void handleClear(javafx.event.ActionEvent event) {
        display.setText("");
        number1 = 0;
        operator = "";
        start = true;
    }

    private long calculate(long num1, long num2, String op) {
        switch (op) {
            case "+" -> {
                return num1 + num2;
            }
            case "-" -> {
                return num1 - num2;
            }
            case "*" -> {
                return num1 * num2;
            }
            case "/" -> {
                if (num2 == 0)
                    return 0;
                return num1 / num2;
            }
        }

        return 0;
    }

    @FXML
    private void handleEquals() {
        if (operator.isEmpty() || start) {
            return;
        }

        long number2 = Long.parseLong(display.getText());
        long result = calculate(number1, number2, operator);
        display.setText(String.valueOf(result));
        operator = "";
        start = true;
    }

}
