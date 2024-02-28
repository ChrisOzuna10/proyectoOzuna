package com.ozuna.farmacianew.controllers;

import com.ozuna.farmacianew.Main;
import com.ozuna.farmacianew.models.Farmacia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {

    @FXML
    private ImageView img_Logo;

    Farmacia farmaciaOzuna = new Farmacia();
    private Stage stage;

    @FXML
    void onInventarioClick(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inventarioScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inventario Farmacia Ozuna");
        stage.setScene(scene);
        stage.show();
        InventarioScreenController inventarioScreenController = fxmlLoader.getController();
        inventarioScreenController.ingresarFarmacia(farmaciaOzuna);
        inventarioScreenController.setStage(stage);
        inventarioScreenController.verInventario();
    }

    @FXML
    void onSalirClick(MouseEvent event) {
        stage.close();
    }

    public void setStage (Stage stage){
        this.stage = stage;
    }

}
