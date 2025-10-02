/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.da.mvc.facturas.Servicios;

import java.util.ArrayList;

import ort.da.mvc.facturas.modelo.Cliente;
import ort.da.mvc.facturas.modelo.Factura;
import ort.da.mvc.facturas.modelo.Producto;

/**
 *
 * @author magda
 */
public class SistemaFacturas {
    
    private static SistemaFacturas instancia; 
    private ArrayList<Factura> facturas = new ArrayList();
 
    
    public static SistemaFacturas getInstancia(){
    
           if ( instancia == null){
                instancia = new SistemaFacturas();
           }
          return instancia;
    }
   
    private SistemaFacturas(){
    
    }
    
    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
    
    
    public boolean agregar(Factura unaFactura){
       facturas.add(unaFactura);
       return true;
    }
    
    public boolean clienteComproProducto(Cliente c, Producto p){
        boolean ret = false;
        for(Factura f: facturas){
            if (f.getCliente().equals(c) && f.tieneProducto(p)){
                ret = true;
            }
        }
      
        return ret;
    }

    public int totalFacturado() {
        int total = 0;
        for(Factura f: facturas){
            total += f.getTotal();
        }
        return total;
    }

    public Factura iniciarFactura(Cliente cliente) {
        Factura nueva = new Factura(cliente);
        this.agregar(nueva);
        return nueva;
    }
   
}
