package com.curso.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//Se excluye del proyecto DataSourceAutoConfiguration para poder ejecutar y 
//comprobar si nuestra aplicacion corre desde el comienzo. Considerando si colocamos 
//como dependencia la conexion a la base de datos.
@SpringBootApplication
public class SpringEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEcommerceApplication.class, args);
	}

}
