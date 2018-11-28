package com.aewinformatica.sis03.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aewinformatica.sis03.entity.Cfop;
import com.aewinformatica.sis03.repository.CfopRepository;

@Service
public class CfopService {

	private CfopRepository cfopRepository;

	public CfopService(CfopRepository cfopRepository) {
		this.cfopRepository = cfopRepository;
	}
	
	public List<Cfop>findAll() {
		
		return cfopRepository.findAll();
	}
	
	public void salvar(Cfop cfop) {
		
		cfopRepository.save(cfop);
	}
	public void remover(Cfop cfop) {
		
	cfopRepository.delete(cfop);
	
	}
	
}
