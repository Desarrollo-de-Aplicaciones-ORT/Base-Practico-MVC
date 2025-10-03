/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.da.mvc.facturas.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author magda
 */
public class Factura {
    
    private Cliente cliente;
    private ArrayList <LineaFactura> lineas = new ArrayList();
    private Date fecha = new Date();
   
    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }
 
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<LineaFactura> getLineas() {
        return lineas;
    }

    public boolean agregarLinea(int cantidad, Producto p){
        LineaFactura nuevaLinea = new LineaFactura(p, cantidad);
        lineas.add(nuevaLinea);
        return true;
    }
    public boolean tieneProducto(Producto unP){
        boolean ret = false;
        for(LineaFactura l: lineas){
            if(l.getProducto()==unP){
                ret = true;
            }
        }
        return ret;       
    }



    @Override
    public String toString() {
        return "Factura{" + "cliente=" + cliente + ", lineas=" + lineas + '}';
    }
  
    public int total(){
        int total = 0;
        for(LineaFactura lf:lineas){
            total+=lf.total();
        }
        return total;
    }

    public int getTotal() {
        int total = 0;
        for(LineaFactura lf:lineas){
            total+=lf.total();
        }
        return total;
    }

   
    
}
