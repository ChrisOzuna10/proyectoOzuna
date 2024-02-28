package com.ozuna.farmacianew.models;

public class Producto {
    String name;
    int precio;
    int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  name +" "+
                "{ Precio=" + precio +
                ", Cantidad=" + cantidad +
                " }";
    }
}
