package com.curso.ecommerce.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.ProductoServices;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	//Logger es para realizar pruebas de la clase Logger. con getLogger llamamos a la clase del controlador .class
	private final Logger LOGGER=LoggerFactory.getLogger(ProductoController.class);
	@Autowired
	private ProductoServices productoService;
	//Mostrar la vista de Productos
	@GetMapping("")
	public String show() {
		return "productos/show";
	}
	//Mostar vista crear producto
	@GetMapping("/crear")
	public String create() {
		return "productos/create";
	}
	//Vamos a guardar el producto
	@PostMapping("/save")
	public String save(Producto producto) {
		LOGGER.info("Este es el producto {}",producto);
		Usuario u=new Usuario(1, "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoService.save(producto);
		return "redirect:/productos";
	}
}
