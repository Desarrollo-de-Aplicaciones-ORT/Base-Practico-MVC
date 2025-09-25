/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ort.da.mvc.facturas.dto;

import java.util.ArrayList;
import java.util.List;
import ort.da.mvc.facturas.modelo.Cliente;

/**
 *
 * @author PC
 */
public class ClienteDto {
    
    private String nombre;
    private String cedula;
    private String email;
    private String ultimaCompra;

    public ClienteDto(Cliente cliente) {
       nombre = cliente.getNombre();
       cedula = cliente.getCedula();
       email = cliente.getEmail();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEmail() {
        return email;
    }

    public String getUltimaCompra() {
        return ultimaCompra;
    }

    public void setUltimaCompra(String ultimaCompra) {
        this.ultimaCompra = ultimaCompra;
    }
    
    
    public static List<ClienteDto> listaDtos(List<Cliente> lista){
        List<ClienteDto> dtos = new ArrayList<>();
        for(Cliente c: lista){
           dtos.add(new ClienteDto(c));
        }
        return dtos;
    }
    
}
