package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.DTO.MatriculaDTO;

public interface IMatriculaService {
	
	public void guardarMatricula (Matricula matricula);
	
	public List<MatriculaDTO> buscarMatriculas ();


}
