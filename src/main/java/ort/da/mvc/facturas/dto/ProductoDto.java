package ort.da.mvc.facturas.dto;

import java.util.ArrayList;
import java.util.List;

import ort.da.mvc.facturas.modelo.Producto;
import ort.da.mvc.facturas.modelo.Proveedor;

public class ProductoDto {
    private String nombre;
    private int precio;
    private int unidades;
    private Proveedor proveedor;
    private int codigo;

    public ProductoDto(Producto producto) {
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.unidades = producto.getUnidades();
        this.proveedor = producto.getProveedor().getNombre()!=null ? producto.getProveedor() : new Proveedor("N/A");
        this.codigo = producto.getCodigo();
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
    public int getCodigo() {
        return codigo;
    }

     public static List<ProductoDto> listaDtos(List<Producto> lista){
        List<ProductoDto> dtos = new ArrayList<>();
        for(Producto p: lista){
           dtos.add(new ProductoDto(p));
        }
        return dtos;
    }
}
