package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardarMateria(Materia materia) {
		materia.setNumEstudiantes(0);
		this.iMateriaRepository.insertarMateria(materia);
		
	}


	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<Materia> buscarMaterias() {
		return this.iMateriaRepository.buscarTodas();
	}


	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public Materia buscarPorId(Integer id) {
		return this.iMateriaRepository.buscarPorId(id);
		
	}

}
