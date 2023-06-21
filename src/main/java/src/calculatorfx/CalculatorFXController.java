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

    private double x, y;
    private double Num1 = 0;
    private String Operator = "+";

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
    private void OnZeroClick(MouseEvent event)
    {
        ResultLabel.setText(String.valueOf(0));
    }

    @FXML
    private void OnSymbolClick(MouseEvent event)
    {

    }
}
