package ort.da.mvc.facturas.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ort.da.mvc.facturas.modelo.Factura;

public class FacturaDto {
    private ClienteDto cliente;
    private java.util.Date fecha;
    private List<LineaFacturaDto> lineas;

    public FacturaDto(ClienteDto cliente, Date fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.lineas = new ArrayList<>();
    }

    public FacturaDto(Factura f) {
        this.cliente = new ClienteDto(f.getCliente());
        this.fecha = f.getFecha();
        this.lineas = f.getLineas().stream()
                        .map(l -> new LineaFacturaDto(l))
                        .collect(Collectors.toList());
        
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente= cliente;
    }

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
     public static List<FacturaDto> listaDtos(List<Factura> lista){
        List<FacturaDto> dtos = new ArrayList<>();
        for(Factura f: lista){
           dtos.add(new FacturaDto(f));
        }
        return dtos;
    }
}
