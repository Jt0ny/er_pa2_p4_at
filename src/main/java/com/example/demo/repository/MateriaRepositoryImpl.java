package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarMateria(Materia materia) {
		this.entityManager.persist(materia);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Materia> buscarTodas() {
		TypedQuery<Materia>query=this.entityManager.createQuery("SELECT m FROM Materia m",Materia.class);
		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia buscarPorId(Integer id) {
		TypedQuery<Materia>query=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.id=:datoId",Materia.class);
		query.setParameter("datoId", id);
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia buscarPorCodigo(String codigo) {
		TypedQuery<Materia>query=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo=:datoCodigo",Materia.class);
		query.setParameter("datoCodigo", codigo);
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizarMateria(Materia materia) {
		this.entityManager.merge(materia);
		
	}

	

}
