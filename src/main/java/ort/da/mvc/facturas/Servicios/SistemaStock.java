
package ort.da.mvc.facturas.Servicios;

import java.util.ArrayList;

import ort.da.mvc.facturas.modelo.Producto;
import ort.da.mvc.facturas.modelo.Proveedor;


public class SistemaStock {

    private static SistemaStock instancia;
    
    private ArrayList<Producto> productos = new ArrayList();
    private ArrayList<Proveedor> proveedores = new ArrayList();
    
    public static SistemaStock getInstancia(){
    
           if ( instancia == null){
                instancia = new SistemaStock();
           }
          return instancia;
    }
    
    private SistemaStock() {
    }
  
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    
    public Producto getProductoMenorPrecio(){
        if(productos.isEmpty()) return null;
        Producto menor = productos.get(0);
        Producto p;
        for(int x=1;x<productos.size();x++){
            p = productos.get(x);
            if (p.getPrecio()<menor.getPrecio()){
                menor = p;
            }
        }            
        
        return menor;
        
      
    }
        
    public void agregar(Proveedor unProveedor){
        proveedores.add(unProveedor);
    }
    
    public  boolean altaProducto(Producto unProducto){
        productos.add(unProducto);
        return true;
    }
   
   
}
