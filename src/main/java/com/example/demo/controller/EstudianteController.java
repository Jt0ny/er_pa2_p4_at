package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping("/vistaEstudiante")
	private String vistaMateria (Estudiante estudiante) {
		return "vistaInsertarEstudiante";
	}
	
	@PostMapping("/guardar")
	private String guardarMateria(Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
		return "redirect:/estudiantes/vistaEstudiante";
	}

}
