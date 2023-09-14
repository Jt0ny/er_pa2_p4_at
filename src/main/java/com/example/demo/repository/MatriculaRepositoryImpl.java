package com.example.demo.repository;

import java.util.List;

import org.hibernate.mapping.TypeDef;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.DTO.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarMatricula(Matricula matricula) {
		this.entityManager.persist(matricula);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> buscarMatriculas() {
	TypedQuery<MatriculaDTO>query=this.entityManager.createQuery("SELECT NEW com.example.demo.repository.modelo.DTO(m.matricula.cedula,m.matricula.apellido,"
			+ "m.materia.nombre,m.materia.codigo,m.fechaMatricula) FROM Matricula m",MatriculaDTO.class);
		return query.getResultList();
	}
	

}
