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

    public Producto productoMasBarato() {
        int precioMenor = Integer.MAX_VALUE;
        Producto productoMasBarato = new Producto();
        for(Producto p : productos){
            if(p.getPrecio() < precioMenor){
                precioMenor = p.getPrecio();
                productoMasBarato = p;
            }
        }
        return productoMasBarato;
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

    public Producto buscarProductoPorCodigo(int codigo) {
        for(Producto p:productos){
            if(p.getCodigo() == codigo){
                return p;
            }
        }
        return null;
    }

     public boolean agregar(Producto producto){
        if(producto == null) {
            System.out.println("Error: El producto es null.");
            return false;
        }
        if (!producto.validar()) {
            System.out.println("Error: El producto no pasó la validación.");
            return false;
        }
        if (this.existeProducto(producto.getNombre())) {
            System.out.println("Error: Ya existe un producto con el nombre '" + producto.getNombre() + "'.");
            return false;
        }
        productos.add(producto);
        System.out.println("Producto agregado correctamente: " + producto.getNombre());
        return true;
    }

    public  boolean altaProveedor(Proveedor unProveedor){
        proveedores.add(unProveedor);
        return true;
    }

    public int generarCodigoProducto() {
        return productos.size() + 1;
    }

    public Proveedor buscarProveedor(String nombreDelProveedor) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getNombre().equalsIgnoreCase(nombreDelProveedor)) {
                return proveedor;
            }
        }
        return null;
    }

    
   
   
}
