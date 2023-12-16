package main;

import controller.ControllerLogin;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewLogin;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // LOGIN
         ViewLogin vl = new ViewLogin(primaryStage);
         ControllerLogin cl = new ControllerLogin(vl, null);
    }
}
