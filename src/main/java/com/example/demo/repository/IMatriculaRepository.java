package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.DTO.MatriculaDTO;

public interface IMatriculaRepository {
	
	public void insertarMatricula (Matricula matricula);
	
	public List<MatriculaDTO> buscarMatriculas ();

}
