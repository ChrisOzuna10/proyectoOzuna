package com.ozuna.farmacianew.controllers;

import com.ozuna.farmacianew.Main;
import com.ozuna.farmacianew.models.Farmacia;
import com.ozuna.farmacianew.models.Jarabe;
import com.ozuna.farmacianew.models.Pastilla;
import com.ozuna.farmacianew.models.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class InventarioScreenController {

    @FXML
    private TextArea inventarioText;

    private Farmacia farmacia;
    private Stage stage;

    @FXML
    void Agregar(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType pastilla = new ButtonType("Pastilla");
        ButtonType jarabe = new ButtonType("Jarabe");
        alert.getButtonTypes().setAll(pastilla,jarabe);
        alert.setTitle("Agregar");
        alert.setHeaderText("¿Que tipo de producto desea agregar?");
        alert.showAndWait().ifPresent(respuesta ->{
            if (respuesta==jarabe){
                farmacia.setNewProducto(pedirJarabe());
            } else {
                farmacia.setNewProducto(pedirPastilla());
            }
        });
        verInventario();
    }

    @FXML
    void Editar(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editar producto");
        dialog.setHeaderText("Ingrese nombre del producto a editar");
        Optional<String> productoEli = dialog.showAndWait();
        productoEli.ifPresent(producto -> {
            int i = 0;
            int iteradorEdit = -1;
            for (Producto producto1: farmacia.getListaProductos()){
                if (producto1.getName().equals(producto)){
                    iteradorEdit = i;
                }
                i++;
            }
            if (iteradorEdit != -1){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType pastilla = new ButtonType("Pastilla");
                ButtonType jarabe = new ButtonType("Jarabe");
                alert.getButtonTypes().setAll(pastilla,jarabe);
                alert.setTitle("Editar");
                alert.setHeaderText("Producto encontrado,¿Que tipo de producto desea agregar ahora?");
                int edit = iteradorEdit;
                alert.showAndWait().ifPresent(respuesta ->{
                    if (respuesta==jarabe){
                        farmacia.editarProducto(edit,pedirJarabe());
                    } else {
                        farmacia.editarProducto(edit,pedirPastilla());
                    }
                });
                verInventario();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Producto no encontrado");
                alert.showAndWait();
            }
        });
    }

    @FXML
    void Eliminar(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Eliminar producto");
        dialog.setHeaderText("Ingrese nombre del producto a eliminar");
        Optional<String> productoEli = dialog.showAndWait();
        productoEli.ifPresent(producto -> {
            int i = 0;
            int iteradorEdit = -1;
            for (Producto producto1: farmacia.getListaProductos()){
                if (producto1.getName().equals(producto)){
                    iteradorEdit = i;
                }
                i++;
            }
            if (iteradorEdit != -1){
                farmacia.elimarProducto(iteradorEdit);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Eliminar");
                alert.setHeaderText("Producto eliminado con exito");
                alert.showAndWait();
                verInventario();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Producto no encontrado");
                alert.showAndWait();
            }
        });
    }

    @FXML
    void Salir(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Farmacia Ozuna");
        stage.setScene(scene);
        stage.show();
        MenuPrincipalController menuPrincipalController = fxmlLoader.getController();
        menuPrincipalController.setStage(stage);
    }

    @FXML
    void limpiarInventario(MouseEvent event) {
        farmacia.limpiarInventario();
        verInventario();
    }

    public void ingresarFarmacia (Farmacia farmaciaOzuna){
        this.farmacia = farmaciaOzuna;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }
    public void verInventario(){
        inventarioText.setText(farmacia.mostrarProducto());
    }
    public Jarabe pedirJarabe(){
        Jarabe newJarabe = new Jarabe();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Agregar Producto");
        dialog.setHeaderText("Nombre del Jarabe:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(newJarabe::setName);
        dialog.setHeaderText("Precio del producto");
        Optional<String> precio = dialog.showAndWait();
        precio.ifPresent(precioProducto -> newJarabe.setPrecio(Integer.parseInt(precioProducto)));
        dialog.setHeaderText("Cantidad de producto");
        Optional<String> cantidad = dialog.showAndWait();
        cantidad.ifPresent(cantidadProducto -> newJarabe.setCantidad(Integer.parseInt(cantidadProducto)));
        dialog.setHeaderText("Cantidad de Ml del producto");
        Optional<String> cantidadMl = dialog.showAndWait();
        cantidadMl.ifPresent(cantidadMililitros -> newJarabe.setCantidadDeMl(Integer.parseInt(cantidadMililitros)));
        return newJarabe;
    }
    public Pastilla pedirPastilla(){
        Pastilla newPastilla = new Pastilla();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Agregar Producto");
        dialog.setHeaderText("Nombre de Pastilla:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(newPastilla::setName);
        dialog.setHeaderText("Precio del producto");
        Optional<String> precio = dialog.showAndWait();
        precio.ifPresent(precioProducto -> newPastilla.setPrecio(Integer.parseInt(precioProducto)));
        dialog.setHeaderText("Cantidad de producto");
        Optional<String> cantidad = dialog.showAndWait();
        cantidad.ifPresent(cantidadProducto -> newPastilla.setCantidad(Integer.parseInt(cantidadProducto)));
        dialog.setHeaderText("Cantidad de pastillas del producto");
        Optional<String> cantidadPas = dialog.showAndWait();
        cantidadPas.ifPresent(cantidadPastillas -> newPastilla.setCantidadDePastillas(Integer.parseInt(cantidadPastillas)));
    return newPastilla;
    }
}
