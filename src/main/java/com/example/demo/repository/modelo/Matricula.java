package com.example.demo.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="matricula")
public class Matricula {
	

	@Id
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
	
	@Column(name = "mtri_id")
	private Integer id;
	
	@Column(name = "mtri_fecha_matricula")
	private LocalDate fechaMatricula;
	
	@ManyToOne
	@JoinColumn(name="mtri_id_materia")
	private Materia materia;
	
	@ManyToOne
	@JoinColumn(name="mtri_id_estudiante")
	private Estudiante estudiante;

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaMatricula=" + fechaMatricula + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	

}




























































/*<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insertar Producto</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
		integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
	<h1>CREAR NUEVO PRODUCTO</h1>
	
	<form th:action="@{/productos/guardar}" th:object="${producto}" th:method="POST">
		<table class="table table-dark table-striped">
			
			<tr>
				<td><label>Nombre:</label></td>
				<td><input type="text"  th:field="${producto.nombre}"></td>
			</tr>
			<tr>
				<td><label>Codido Barras:</label></td>
				<td><input type="text"  th:field="${producto.codBarras}"></td>
			</tr>
			<tr>
				<td><label>Categoria:</label></td>
				<td><input type="text"   th:field="${producto.categoria}"></td>
			</tr>
	
		</table>
		<input class="btn btn-dark" type="submit" value="Guardar">
	</form>
</body>

</html>*/