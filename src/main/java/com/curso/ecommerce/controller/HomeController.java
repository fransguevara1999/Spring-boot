package com.curso.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.ecommerce.model.DetalleOrden;
import com.curso.ecommerce.model.Orden;
import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.service.ProductoServices;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final Logger log=LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private ProductoServices productoService;
	//Para almacenar los detalles de la orden
	private List<DetalleOrden> detalles=new ArrayList<DetalleOrden>();
	
	//Datos de la orden
	Orden orden=new Orden();
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "usuario/home";
	}
	
	@GetMapping("/productohome/{id}")
	public String productoHome(@PathVariable Integer id,Model model) {
		Producto producto=new Producto();
		Optional<Producto> optionalProducto=productoService.get(id);
		producto=optionalProducto.get();
		log.info("Id Producto enviado como parametro {}",id);
		model.addAttribute("producto", producto);
		
		return "usuario/productohome";
	}
	
	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad) {
		DetalleOrden detalleOrden= new DetalleOrden();
		Producto producto=new Producto();
		double sumaTotal=0;
		Optional<Producto> optionalProducto=productoService.get(id);
		log.info("producto añadido:{}", optionalProducto.get());
		log.info("Cantidad:{}", cantidad);
		return "usuario/carrito.html";
	}

	
	
}