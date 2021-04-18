package com.nicolastito.cursosts.services;

import java.util.Optional;

import com.nicolastito.cursosts.domain.Client;
import com.nicolastito.cursosts.repositories.ClientRepository;
import com.nicolastito.cursosts.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Object not found! Id: " + id + ", Type: " + Client.class.getName(), null));
	}
}
