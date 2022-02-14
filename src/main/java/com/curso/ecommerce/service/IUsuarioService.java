package com.curso.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Usuario;


public interface IUsuarioService {
	Optional<Usuario> findById(Integer id);

}
