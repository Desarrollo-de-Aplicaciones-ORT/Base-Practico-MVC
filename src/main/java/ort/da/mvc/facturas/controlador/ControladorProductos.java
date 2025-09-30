package ort.da.mvc.facturas.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ort.da.mvc.facturas.Servicios.SistemaStock;
import ort.da.mvc.facturas.dto.ProductoDto;
import ort.da.mvc.facturas.modelo.Producto;
import ort.da.mvc.facturas.modelo.Proveedor;
import ort.da.mvc.facturas.modelo.Respuesta;

@RestController
@RequestMapping("/productos")
public class ControladorProductos {
    private Producto producto = null;
    SistemaStock sistemaStock = SistemaStock.getInstancia();

    @GetMapping
    public List<ProductoDto> obtenerProductos() {
        return ProductoDto.listaDtos(SistemaStock.getInstancia().getProductos());
    }

    @PostMapping("/vistaConectada")
    public List<Respuesta> vistaConectada() {
        return Respuesta.lista(productos(),
                new Respuesta("habilitarIngreso", false));
    }

    @PostMapping("/ingresarNombre")
    public List<Respuesta> ingresarNombre(@RequestParam String nombre) {
        producto = new Producto();
        boolean nombreValido = producto.setNombre(nombre);
        if (!nombreValido) {
            return Respuesta.lista(mensaje("Nombre incorrecto"));
        }
        Producto tmp = SistemaStock.getInstancia().buscarProducto(nombre);
        if (tmp != null) {
            String nombreDelProveedor = tmp.getProveedor() != null ? tmp.getProveedor().getNombre() : "N/A";
            return Respuesta.lista(mensaje("Ya existe el producto"),
                    producto(tmp), new Respuesta("nombreProveedor", nombreDelProveedor));
        }
        return Respuesta.lista(new Respuesta("habilitarIngreso", true));
    }

    @PostMapping("/guardarProducto")
    public List<Respuesta> guardarProducto(@RequestParam String nombre, @RequestParam int precio,
            @RequestParam int unidades, @RequestParam String nombreDelProveedor) {
        /*if (producto == null)
            return Respuesta.lista(mensaje("No se ha ingresado un producto"));*/
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setUnidades(unidades);
        Proveedor proveedor = sistemaStock.buscarProveedor(nombreDelProveedor);
        producto.setProveedor(proveedor);
        producto.setCodigo(SistemaStock.getInstancia().generarCodigoProducto());
        if (SistemaStock.getInstancia().agregar(producto)) {
            producto = null;
            return Respuesta.lista(productos(),
                    new Respuesta("limpiarEntradas", true),
                    new Respuesta("habilitarIngreso", false));
        } else {
            return Respuesta.lista(mensaje("No se pudo agregar el producto"));
        }
    }

    private Respuesta productos() {

        return new Respuesta("productos",
                ProductoDto.listaDtos(SistemaStock.getInstancia().getProductos()));

    }

    private Respuesta mensaje(String texto) {
        return new Respuesta("mensaje", texto);

    }

    private Respuesta producto(Producto p) {

        return new Respuesta("producto",
                new ProductoDto(p));

    }
}
