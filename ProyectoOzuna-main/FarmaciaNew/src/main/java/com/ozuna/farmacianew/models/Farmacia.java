package com.ozuna.farmacianew.models;
import java.util.ArrayList;

public class Farmacia {
    ArrayList<Producto> listaProductos = new ArrayList<>();

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
    public void setNewProducto(Producto newProducto) {
        listaProductos.add(newProducto);
    }
    public String mostrarProducto(){
        String inventario = "";
        for (Producto iterador: listaProductos){
            inventario = inventario + iterador.toString() + "\n";
        }
        return inventario;
    }
    public void editarProducto(int iteradorProducto,Producto newProducto){
        listaProductos.set(iteradorProducto,newProducto);
    }
    public void elimarProducto(int iteradorProducto){
        listaProductos.remove(iteradorProducto);
    }
    public void limpiarInventario(){
        listaProductos.clear();
    }
}
