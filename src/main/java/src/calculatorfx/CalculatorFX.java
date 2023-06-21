package src.calculatorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CalculatorFX extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorFX.class.getResource("CalculatorFX.fxml"));
        Scene Scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(Scene);
        primaryStage.setResizable(false);

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene.setFill(Color.TRANSPARENT);

        primaryStage.setTitle("Calculator");



        primaryStage.show();

        // Add an icon
        Image Image = new Image("C:\\Users\\gogol\\Documents\\Java\\CalculatorFX\\src\\main\\resources\\src\\calculatorfx\\Icon.png");
        primaryStage.getIcons().add(Image);

        // Load the method Init()
        ((CalculatorFXController)fxmlLoader.getController()).Init(primaryStage);
    }

    public void run()
    {
        launch();
    }
}
