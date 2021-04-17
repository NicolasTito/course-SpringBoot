package com.nicolastito.cursosts.services;

import java.util.Optional;

import com.nicolastito.cursosts.domain.Categoria;
import com.nicolastito.cursosts.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
