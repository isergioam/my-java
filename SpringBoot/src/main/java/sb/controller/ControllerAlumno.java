package sb.controller;

import sb.model.Alumno;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlumno {

	@GetMapping("/alumno/{id}")
	public Alumno obtenerAlumno(@PathVariable int id) {
		return new Alumno(id, "Alumno" + id);
	}
	
	@GetMapping("/buscar-alumno")
	public String buscarAlumno(@RequestParam String nombre, @RequestParam int edad) {
		return "Alumno: " + nombre + " de " + edad + " años. Encontrado!" ;
	}

}
