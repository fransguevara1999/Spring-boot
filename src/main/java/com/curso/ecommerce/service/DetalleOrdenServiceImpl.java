package com.curso.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.curso.ecommerce.model.DetalleOrden;
import com.curso.ecommerce.repository.IDetalleOrdenRepository;

public class DetalleOrdenServiceImpl implements IDetalleOrdenService{

	@Autowired
	private IDetalleOrdenRepository detalleOrdenRepository;
	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		
		return detalleOrdenRepository.save(detalleOrden);
	}

}
