
package ort.da.mvc.facturas.Servicios;

import java.util.ArrayList;

import ort.da.mvc.facturas.modelo.Cliente;
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

    public boolean existeProducto(String unNombre) {
           return buscarProducto(unNombre)!=null;
    }
    public Producto buscarProducto(String unNombre) {
           for(Producto p:productos){
               if(p.getNombre().equals(unNombre)){
                   return p;
               }
           }
           return null;
    }

     public boolean agregar(Producto producto){
        if(producto==null) return false;
        boolean ok = false;

        if (producto.validar() && !this.existeProducto(producto.getNombre())){
            productos.add(producto);
            ok=true;
           
        }
        
        return ok;
    }

    public  boolean altaProveedor(Proveedor unProveedor){
        proveedores.add(unProveedor);
        return true;
    }

    public Object generarCodigoProducto() {
        return "P" + (productos.size() + 1);
    }
   
   
}
