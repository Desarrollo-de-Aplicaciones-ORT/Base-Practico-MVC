package ort.da.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ort.da.mvc.facturas.modelo.DatosPrueba;

@SpringBootApplication
public class MvcApplication {

	public static void main(String[] args) {
            DatosPrueba.cargar();
            SpringApplication.run(MvcApplication.class, args);
	}

}
