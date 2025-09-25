/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.da.mvc.facturas.modelo;

import java.util.ArrayList;

/**
 *
 * @author magda
 */
public class Proveedor {
    
    private String nombre;
    private ArrayList<Producto> productos = new ArrayList();

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    protected boolean agregar(Producto p){
        return productos.add(p);
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
    
}
