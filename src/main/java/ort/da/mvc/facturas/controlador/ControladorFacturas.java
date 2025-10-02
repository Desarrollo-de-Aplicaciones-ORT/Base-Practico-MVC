package ort.da.mvc.facturas.controlador;

import org.springframework.web.bind.annotation.RestController;

import ort.da.mvc.facturas.Servicios.SistemaClientes;
import ort.da.mvc.facturas.Servicios.SistemaFacturas;
import ort.da.mvc.facturas.dto.FacturaDto;
import ort.da.mvc.facturas.modelo.Cliente;
import ort.da.mvc.facturas.modelo.Factura;
import ort.da.mvc.facturas.modelo.Respuesta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/facturas")
public class ControladorFacturas {

    private Cliente cliente = null;

    private Factura factura = null;

    SistemaFacturas sistemaFacturas = SistemaFacturas.getInstancia();
    SistemaClientes sistemaClientes = SistemaClientes.getInstancia();

    @PostMapping("/vistaConectada")
    public List<Respuesta> vistaConectada() {
        return Respuesta.lista(facturas(),
                new Respuesta("habilitarIngreso", false));
    }

    @GetMapping("/totalFacturado")
    public int getTotalFacturado() {
        return sistemaFacturas.totalFacturado();
    }

    @PostMapping("/ingresarCedula")
    public List<Respuesta> iniciarFactura(@RequestParam String cedula) {
        Cliente cliente = sistemaClientes.buscarCliente(cedula.trim());
        if (cliente == null) {
            return Respuesta.lista(new Respuesta("mensaje", "Cliente no registrado"));
        }

        factura = sistemaFacturas.iniciarFactura(cliente);

        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return Respuesta.lista(
                new Respuesta("nombreCliente", cliente.getNombre()),
                new Respuesta("fechaFactura", fecha),
                new Respuesta("totalFactura", "$0"));
    }

    private Respuesta facturas() {
        
        return new Respuesta("facturas",
                      FacturaDto.listaDtos(sistemaFacturas.getFacturas()));
        
    }


    private Respuesta mensaje(String texto) {
        return new Respuesta("mensaje",texto);
    }

}
