package ort.da.mvc.facturas.dto;

import ort.da.mvc.facturas.modelo.LineaFactura;

public class LineaFacturaDto {
    private ProductoDto producto;
    private int cantidad;

    public LineaFacturaDto() {
    }

    public LineaFacturaDto(ProductoDto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public LineaFacturaDto(LineaFactura linea) {
        this.producto = new ProductoDto(linea.getProducto());
        this.cantidad = linea.getCantidad();
    }   

    public ProductoDto getProducto() {
        return producto;
    }

    public void setProducto(ProductoDto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
