/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.da.mvc.facturas.modelo;

import ort.da.mvc.facturas.Servicios.SistemaStock;

/**
 *
 * @author magda
 */
public class Producto {
    private String nombre;
    private int precio;
    private int unidades;
    private Proveedor proveedor;
    private int codigo;

    public Producto() {
    }

    public Producto(String nombre, int precio, int stock, Proveedor proveedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = stock;
        this.proveedor = proveedor;
        this.codigo = SistemaStock.getInstancia().getProductos().size() + 1; // Genera un código único basado en el
                                                                             // tamaño de la lista actual
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;

    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        if (verificarNombre(nombre)) {
            this.nombre = nombre;
            return true;
        }
        return false;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", unidades=" + unidades + ", proveedor="
                + proveedor;
    }

    /*
     * 3-El sistema verifica el nombre (que no sea vacio o contenga solo espacios y
     * que el largo sea menor a 50 caracteres), verifica que no exista un producto
     * ingresado con el mismo nombre, y habilita la posibilidad de seleccionar el
     * proveedor, de ingresar el precio, las unidades y de guardar el producto.
    */

    public boolean verificarNombre(String nombre2) {
        return nombre2 != null && !nombre2.trim().equals("") && nombre2.length() < 50;
    }

    public boolean verificarPrecio(int precio2) {
        return precio2 > 0;
    }

    public boolean verificarUnidades(int unidades2) {
        return unidades2 >= 0;
    }

    public boolean validar() {
        return verificarNombre(nombre) && verificarPrecio(precio) && verificarUnidades(unidades);
    }

    public void setCodigo(Object generarCodigoProducto) {
        // No hace nada, el codigo se genera en el sistema de stock
    }

}
