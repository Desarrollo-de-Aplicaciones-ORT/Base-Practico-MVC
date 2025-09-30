package ort.da.mvc.facturas.controlador;

import org.springframework.web.bind.annotation.RestController;

import ort.da.mvc.facturas.Servicios.SistemaStock;
import ort.da.mvc.facturas.modelo.Proveedor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ControladorProveedores {
    private SistemaStock sistemaStock = SistemaStock.getInstancia();

    @GetMapping("/proveedores")
    public List<Proveedor> getProveedores() {
        return sistemaStock.getProveedores();
    }
    
}
