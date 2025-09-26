/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.da.mvc.facturas.modelo;

import ort.da.mvc.facturas.Servicios.SistemaClientes;
import ort.da.mvc.facturas.Servicios.SistemaFacturas;
import ort.da.mvc.facturas.Servicios.SistemaStock;

/**
 *
 * @author magda
 */
public class DatosPrueba {

    public static void cargar() {

        SistemaStock sStock = SistemaStock.getInstancia();

        Proveedor pA = new Proveedor("Proveedor A");
        Proveedor pB = new Proveedor("Proveedor B");
        Proveedor pC = new Proveedor("Proveedor C");

        sStock.altaProveedor(pA);
        sStock.altaProveedor(pB);
        sStock.altaProveedor(pC);

        Producto caramelo = new Producto("Caramelo", 2, 3000, pA);
        Producto camisa = new Producto("Camisa", 1300, 1000, pB);
        Producto computadora = new Producto("Computadora", 20000, 40, pC);

        sStock.agregar(caramelo);
        sStock.agregar(camisa);
        sStock.agregar(computadora);

        SistemaClientes sClientes = SistemaClientes.getInstancia();

        Cliente juan = new Cliente("12345678", "Juan", "juan@mail.uy");
        Cliente ana = new Cliente("13456789", "Ana", "ana@mail.uy");
        Cliente mario = new Cliente("21234567", "Mario", "mario@mail.uy");

        sClientes.agregar(juan);
        sClientes.agregar(ana);
        sClientes.agregar(mario);

        SistemaFacturas sFacturas = SistemaFacturas.getInstancia();

        Factura f1 = new Factura(juan);
        f1.agregar(30, caramelo);
        f1.agregar(2, camisa);
        f1.agregar(1, computadora);

        sFacturas.agregar(f1);

        Factura f2 = new Factura(ana);
        f2.agregar(400, caramelo);
        f2.agregar(20, camisa);
        f2.agregar(10, computadora);

        sFacturas.agregar(f2);

        Factura f3 = new Factura(mario);

        f3.agregar(1, camisa);
        f3.agregar(1, computadora);

        sFacturas.agregar(f3);
    }

}
