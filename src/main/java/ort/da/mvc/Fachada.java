package ort.da.mvc;

import java.util.ArrayList;
import java.util.List;

import ort.da.mvc.facturas.Servicios.SistemaClientes;
import ort.da.mvc.facturas.Servicios.SistemaFacturas;
import ort.da.mvc.facturas.Servicios.SistemaStock;
import ort.da.mvc.facturas.modelo.Cliente;
import ort.da.mvc.facturas.modelo.Factura;
import ort.da.mvc.facturas.modelo.Producto;
import ort.da.mvc.facturas.modelo.Proveedor;

public class Fachada {
    private SistemaClientes sistemaClientes;
    private SistemaFacturas sistemaFacturas;
    private SistemaStock sistemaStock;


    public static Fachada getInstancia(){
        return instancia;
    }

    // CLIENTES

    //Get clientes
    public List<Cliente> getClientes(){
        return sistemaClientes.getClientes();
    }

    // Clientes que no compraron el producto mas barato
    public List<Cliente> clientesNoCompraronProductoMenorPrecio() {
        return sistemaClientes.clientesNoCompraronProductoMenorPrecio();
    }

    // Clientes que compraron el producto mas barato
    public List<Cliente> clientesQueCompraronElMasBarato() {
        return sistemaClientes.clientesQueCompraronElMasBarato();
    }

    // Existe el cliente?
    public boolean existeCliente(String cedula) {
        return sistemaClientes.existeCliente(cedula);
    }

    //Buscar cliente
    public Cliente buscarCliente(String cedula) {
        return sistemaClientes.buscarCliente(cedula);
    }

    //Agregar el cliente
    public boolean agregarCliente(Cliente c) {
        return sistemaClientes.agregar(c);
    }


    // Facturas

    //Get facturas
    public List<Factura> geFacturas(){
        return sistemaFacturas.getFacturas();
    }

    // Agregar factura
    public boolean agregarFactura(Factura f){
        return sistemaFacturas.agregar(f);
    }

    //El cliente compro el producto?
    public boolean clienteComproProducto(Cliente c, Producto p){
        return sistemaFacturas.clienteComproProducto(c, p);
    }

    //Calcular el total facturado en el sistema
    public int totalFacturado(){
        return sistemaFacturas.totalFacturado();
    }

    //Iniciar una factura
    public Factura iniciarFactura(Cliente c){
        return sistemaFacturas.iniciarFactura(c);
    }

    //Agregar una linea a la factura
    public void agregarLineaFactura(Factura f, Producto p, int cantidad){
        sistemaFacturas.agregarLineaFactura(f, p, cantidad);
    }


    // STOCK

    //Get Productos
    public List<Producto> getProductos(){
        return sistemaStock.getProductos();
    }

    //Get proveedores
    public List<Proveedor> getProveedores(){
        return sistemaStock.getProveedores();
    }

    //Agregar Producto
    public void agregarProducto(Producto p){
        sistemaStock.agregar(p);
    }

    //Agregar Proveedor
    public void agregarProveedor(Proveedor p){
        sistemaStock.altaProveedor(p);
    }

    //Producto con menor precio
    public Producto productoMasBarato(){
        return sistemaStock.productoMasBarato();
    }

    //Existe el producto?
    public boolean existeProducto(String nombre){
        return sistemaStock.existeProducto(nombre);
    }

    //Buscar producto por nombre
    public Producto buscaProductoporNombre(String nombre){
        return sistemaStock.buscarProducto(nombre);
    }

    //Buscar producto por codigo
    public Producto buscarProductoPorCodigo(int codigo){
        return sistemaStock.buscarProductoPorCodigo(codigo);
    }



}
