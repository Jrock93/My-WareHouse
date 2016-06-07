package com.example.jrock.warehouse;

/**
 * Created by Jrock on 5/6/2016.
 */
public class ItemsT {
    String nombre; // Título del item

    int existencias; // Descripción del item
    double precio; // Imagen del ítem
    // Constructor por defecto de la clase
    public ItemsT(){}
    // Constructor con parámetros para inicializar el item
    public ItemsT(String nombre,int existencias, double precio){
        this.nombre = nombre;
        this.existencias = existencias;
        this.precio = precio;
    }
    // Aqui inicia el GET y el SET para cada propiedad de la clase
    public String getNombre() { return nombre; }
    public void setNombre(String nombre_) { this.nombre = nombre_; }
    public int getExistencias() { return this.existencias; }
    public void setExistencias(int existencias) { this.existencias = existencias; }
    public double getPrecio() { return this.precio; }
    public void setPrecio(int precio) { this.precio = precio; }
}