package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.DTO.MatriculaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardarMatricula(Matricula matricula) {
		
		Materia m1=this.iMateriaRepository.buscarPorCodigo(matricula.getMateria().getCodigo());
		m1.setNumEstudiantes(m1.getNumEstudiantes()+1);
		
		this.iMateriaRepository.actualizarMateria(m1);
		
		Estudiante e1=this.estudianteRepository.buscarPorCedula(matricula.getEstudiante().getCedula());
		
		matricula.setEstudiante(e1);
		matricula.setMateria(m1);
		matricula.setFechaMatricula(LocalDate.now());
		this.iMatriculaRepository.insertarMatricula(matricula);
	
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<MatriculaDTO> buscarMatriculas() {
		return this.iMatriculaRepository.buscarMatriculas();
	}

}
