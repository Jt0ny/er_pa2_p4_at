package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {

	public void insertarMateria(Materia materia);
	
	public List<Materia> buscarTodas();
	
	public Materia buscarPorId(Integer id);
	
	public Materia buscarPorCodigo (String codigo);
	
	
	public void actualizarMateria (Materia materia);
	
	
}
