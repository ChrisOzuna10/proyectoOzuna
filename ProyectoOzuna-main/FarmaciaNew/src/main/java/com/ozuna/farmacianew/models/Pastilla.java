package com.ozuna.farmacianew.models;

public class Pastilla extends Producto {
    int cantidadDePastillas;

    public int getCantidadDePastillas() {
        return cantidadDePastillas;
    }

    public void setCantidadDePastillas(int cantidadDePastillas) {
        this.cantidadDePastillas = cantidadDePastillas;
    }
    @Override
    public String toString() {
        return  name +" "+
                "= Precio: " + precio +
                ", Cantidad: " + cantidad +
                ", Cantidad de pastillas en el empaque: " + cantidadDePastillas;
    }
}
