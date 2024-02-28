package com.ozuna.farmacianew.models;

public class Jarabe extends Producto{
    int cantidadDeMl;

    public int getCantidadDeMl() {
        return cantidadDeMl;
    }

    public void setCantidadDeMl(int cantidadDeMl) {
        this.cantidadDeMl = cantidadDeMl;
    }
    @Override
    public String toString() {
        return  name +" "+
                "= Precio: " + precio +
                ", Cantidad: " + cantidad +
                ", Cantidad en producto: " + cantidadDeMl +"Ml";
    }
}
