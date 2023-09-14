package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.DTO.MatriculaDTO;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@GetMapping("/vistaMatricula")
	private String vistaMateria (Matricula matricula) {
		return "vistaInsertarMatricula";
	}
	
	@PostMapping("/guardar")
	private String guardarMateria(Matricula matricula) {
		this.iMatriculaService.guardarMatricula(matricula);
		return "redirect:/matriculas/listaMatriculas";
	}

	
	@GetMapping("/listaMatriculas")
	private String listaEstudiantes (MatriculaDTO matriculaDto,Model model) {
		List<MatriculaDTO> materias=this.iMatriculaService.buscarMatriculas();
		model.addAttribute("matriculaDto",matriculaDto);
		return "listaMatriculas";
	}
	
	
	
	

}
