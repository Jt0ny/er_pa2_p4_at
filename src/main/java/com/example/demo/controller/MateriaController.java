package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;
	
	@GetMapping("/vistaMateria")
	private String vistaMateria (Materia materia) {
		return "vistaInsertarMateria";
	}
	
	@PostMapping("/guardar")
	private String guardarMateria(Materia materia) {
		this.iMateriaService.guardarMateria(materia);
		return "redirect:/materias/listaMaterias";
	}
	
	@GetMapping("/listaMaterias")
	private String listaEstudiantes (Materia materia,Model model) {
		List<Materia>materias=this.iMateriaService.buscarMaterias();
		model.addAttribute("materias",materias);
		return "listaMaterias";
	}
	
	@GetMapping("/buscar/{id}")
	public String buscarPorId(@PathVariable("id") Integer id, Model model) {
		Materia materia = this.iMateriaService.buscarPorId(id);
		model.addAttribute("materia", materia);
		return "vistaBusquedaMateria";

	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@GetMapping("/vistaEstudiante")
	private String vistaEstudiante (Estudiante estudiante) {
		return "vistaInsertarEstudiante";
	}
	
	@PostMapping("/guardar")
	private String guardarEstudiante(Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
		return "redirect:/estudiantes/listaEstudiantes";
	}
	
	@GetMapping("/listaEstudiantes")
	private String listaEstudiantes (Estudiante estudiante,Model model) {
		List<Estudiante> list=this.estudianteService.buscarTodos();
		model.addAttribute("estudiantes",list);
		return "listaEstudiantes";
	}
	
	@DeleteMapping("/eliminar/{cedula}")
	private String eliminarEstudiante(@PathVariable("cedula")String cedula) {
		this.estudianteService.eliminarEstudiante(cedula);
		return "redirect:/estudiantes/listaEstudiantes";
	}
	
	@GetMapping("/buscar/{cedula}")
	public String buscarPorId(@PathVariable("cedula") String cedula, Model model) {
		Estudiante estu = this.estudianteService.buscarEstudiante(cedula);
		model.addAttribute("estudiante", estu);
		return "vistaBusquedaEstudiante";

	}
	
	@PutMapping("/actualizar/{cedula}")
	public String actualizarPropietario(@PathVariable("cedula")String cedula,Estudiante estudiante) {
		this.estudianteService.actualizarPorCedula(estudiante);
		return "redirect:/estudiantes/listaEstudiantes";
	}

}*/

}
