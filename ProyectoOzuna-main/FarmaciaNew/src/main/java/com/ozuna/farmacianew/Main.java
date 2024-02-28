package com.ozuna.farmacianew;

import com.ozuna.farmacianew.controllers.MenuPrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Farmacia Ozuna");
        stage.setScene(scene);
        stage.show();
        MenuPrincipalController menuPrincipalController = fxmlLoader.getController();
        menuPrincipalController.setStage(stage);
    }
    public static void main(String[] args) {
        launch();
    }
}