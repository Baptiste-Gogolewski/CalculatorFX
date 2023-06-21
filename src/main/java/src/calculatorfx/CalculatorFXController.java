package src.calculatorfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CalculatorFXController
{
    @FXML
    private Pane TitlePane;

    @FXML
    private ImageView CloseButton, MinimizeButton;

    @FXML
    private Label ResultLabel;

    private String Operator = "";

    // Permet de savoir si un operateur est selectionné
    private boolean OperatorSelected;
    private boolean UpdateScreen;

    private double x, y, Calcul;

    public void Init(Stage primaryStage)
    {
        // Permet de faire bouger la fenêtre
        TitlePane.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        TitlePane.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });

        // Ferme la fenêtre
        CloseButton.setOnMouseClicked(mouseEvent -> {
            primaryStage.close();
        });

        // Minimise la fenêtre
        MinimizeButton.setOnMouseClicked(mouseEvent -> {
            primaryStage.setIconified(true);
        });
    }

    @FXML
    private void CalculResult()
    {
        switch (Operator)
        {
            case "+":
                Calcul = Calcul + Double.valueOf(ResultLabel.getText());
                break;

            case "-":
                Calcul = Calcul - Double.valueOf(ResultLabel.getText());
                break;

            case "*":
                Calcul = Calcul * Double.valueOf(ResultLabel.getText());
                break;

            case "/":
                Calcul = Calcul / Double.valueOf(ResultLabel.getText());
                break;

            default:
                break;
        }
        Operator = "";
        OperatorSelected = false;
        ResultLabel.setText(Double.toString(Calcul));
    }

    private void AddNumber(int number)
    {
        String str = String.valueOf(number);
        if (UpdateScreen)
            UpdateScreen = false;
        else
        {
            if (!(ResultLabel.getText().equals("0")))
                str = ResultLabel.getText() + str;
        }
        ResultLabel.setText(str);
    }

    private void ClickOnOperator(String operator)
    {
        System.out.println(operator);
        if (OperatorSelected)
        {
            CalculResult();
            ResultLabel.setText(Double.toString(Calcul));
            OperatorSelected = false;
            Operator = operator;
            UpdateScreen = true;
        }
        else
        {
            OperatorSelected = true;
            UpdateScreen = true;
            Operator = operator;
            Calcul = Double.valueOf(ResultLabel.getText());
        }
    }

    @FXML
    private void OnZeroClick(MouseEvent event)
    {
        AddNumber(0);
    }

    @FXML
    private void OnOneClick(MouseEvent event)
    {
        AddNumber(1);
    }

    @FXML
    private void OnTwoClick(MouseEvent event)
    {
        AddNumber(2);
    }

    @FXML
    private void OnThreeClick(MouseEvent event)
    {
        AddNumber(3);
    }

    @FXML
    private void OnFourClick(MouseEvent event)
    {
        AddNumber(4);
    }

    @FXML
    private void OnFiveClick(MouseEvent event)
    {
        AddNumber(5);
    }

    @FXML
    private void OnSixClick(MouseEvent event)
    {
        AddNumber(6);
    }

    @FXML
    private void OnSevenClick(MouseEvent event)
    {
        AddNumber(7);
    }

    @FXML
    private void OnHeightClick(MouseEvent event)
    {
        AddNumber(8);
    }

    @FXML
    private void OnNineClick(MouseEvent event)
    {
        AddNumber(9);
    }

    @FXML
    private void OnDivideClick(MouseEvent event)
    {
        ClickOnOperator("/");
    }

    @FXML
    private void OnMultiplyClick(MouseEvent event)
    {
        ClickOnOperator("*");
    }

    @FXML
    private void OnPlusClick(MouseEvent event)
    {
        ClickOnOperator("+");
    }

    @FXML
    private void OnMinusClick(MouseEvent event)
    {
        ClickOnOperator("-");
    }

    @FXML
    private void OnDotClick(MouseEvent event)
    {
        ResultLabel.setText(ResultLabel.getText() + ".");
    }

    @FXML
    private void OnClearClick(MouseEvent event)
    {
        ResultLabel.setText("0");
        OperatorSelected = false;
        UpdateScreen = false;
    }
}
