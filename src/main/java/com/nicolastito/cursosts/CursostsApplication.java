package com.nicolastito.cursosts;

import java.util.Arrays;

import com.nicolastito.cursosts.domain.Categoria;
import com.nicolastito.cursosts.domain.Product;
import com.nicolastito.cursosts.repositories.CategoriaRepository;
import com.nicolastito.cursosts.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursostsApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursostsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(1, "Computing");
		Categoria cat2 = new Categoria(2, "Desk");

		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "printer", 200.00);
		Product p3 = new Product(null, "Mouse", 40.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
