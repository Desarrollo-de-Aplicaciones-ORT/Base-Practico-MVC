package ort.da.mvc.facturas.controlador;

import org.springframework.web.bind.annotation.RestController;

import ort.da.mvc.facturas.Servicios.SistemaFacturas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/facturas")
public class ControladorFacturas {

    SistemaFacturas sistemaFacturas = SistemaFacturas.getInstancia();

    @GetMapping("/totalFacturado")
    public int getTotalFacturado() {
        return sistemaFacturas.totalFacturado();
    }
    
}
