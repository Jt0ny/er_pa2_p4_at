package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {
	
	public void guardarMateria(Materia materia);
	
	public List<Materia> buscarMaterias();
	
	public Materia buscarPorId(Integer id);


}
