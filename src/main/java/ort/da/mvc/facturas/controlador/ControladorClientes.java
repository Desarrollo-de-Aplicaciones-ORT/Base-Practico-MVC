package ort.da.mvc.facturas.controlador;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ort.da.mvc.facturas.Servicios.SistemaClientes;
import ort.da.mvc.facturas.dto.ClienteDto;
import ort.da.mvc.facturas.modelo.Cliente;
import ort.da.mvc.facturas.modelo.Respuesta;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/clientes")

public class ControladorClientes {
    
    private Cliente cliente = null;
    
    @PostMapping("/vistaConectada")
    public List<Respuesta> vistaConectada() {
       return Respuesta.lista(clientes(), 
                              new Respuesta("habilitarIngreso",false));
    }
    
    @PostMapping("/ingresarCedula")
    public List<Respuesta> ingresarCedula(@RequestParam String cedula) {
       cliente = new Cliente();
       if(!cliente.setCedula(cedula)){
           return Respuesta.lista(mensaje("Cedula incorrecta"));
       }
       Cliente tmp = SistemaClientes.getInstancia().buscarCliente(cedula);
       if(tmp!=null){
           return Respuesta.lista(mensaje("Ya existe el cliente"),
                                  cliente(tmp));
       }
       return Respuesta.lista(new Respuesta("habilitarIngreso",true));
    }
     @PostMapping("/guardarCliente")
    public List<Respuesta> guardarCliente(@RequestParam String nombre,@RequestParam String email) {
        if(cliente == null)  return Respuesta.lista(mensaje("No se ha ingresado una cedula"));
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        if(SistemaClientes.getInstancia().agregar(cliente)){
            cliente = null;
            return Respuesta.lista(clientes(),
                                   new Respuesta("limpiarEntradas",true),
                                   new Respuesta("habilitarIngreso",false));
        }else{
            return Respuesta.lista(mensaje("No se pudo agregar el cliente"));
        }
    }

    private Respuesta clientes() {
        
        return new Respuesta("clientes",
                      ClienteDto.listaDtos(SistemaClientes.getInstancia().getClientes()));
        
    }
    private Respuesta mensaje(String texto) {
        return new Respuesta("mensaje",texto);
        
    }
    private Respuesta cliente(Cliente c) {
        
        return new Respuesta("cliente",
                      new ClienteDto(c));
        
    }
    
    
}

/*
Posible PROMPT inicial utilizado para generar la inerfaz de usuario web en html y css:
=============================================================================
Quiero que escribas una pagina en html que permita ingresar un cliente (cedula, nombre, email). 
Quiero un boton que diga "buscar" para que luego de ingresar la cedula se habiliten los campos 
para el nombre y el email y un boton para guardar el cliente.  
Cada boton llama a un endpoint a traves de un metodo "submit" 
(uno pasa la cedula y el otro el nombre y el email) 
Quiero tambien una tabla para ir mostrando los clientes que se van agregando y 
una funcion para habilitar y deshabilitar los campos nombre, email y el boton de guardar. 
Por favor haz una estetica moderna y bella pero sobria. Separa el css del html.
El archivo html y css deben estar en una carpeta llamada facturas bajo la carpeta static. 
*/
