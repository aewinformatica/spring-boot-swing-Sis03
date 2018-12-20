package com.aewinformatica.sis03.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aewinformatica.sis03.entity.Cliente;
import com.aewinformatica.sis03.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public void salvar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void remover(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
