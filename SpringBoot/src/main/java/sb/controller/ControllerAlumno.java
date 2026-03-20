package sb.controller;

import sb.model.Alumno;
import sb.service.ServiceAlumno;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlumno {
	
	private final ServiceAlumno serviceAlumno;

	public ControllerAlumno(ServiceAlumno service) {
		this.serviceAlumno = service;
	}

	@GetMapping("/alumno/{id}")
	public Alumno obtenerAlumno(@PathVariable int id) {
		return new Alumno(id, "Alumno" + id);
	}
	
	@GetMapping("/buscar-alumno")
	public String buscarAlumno(@RequestParam String nombre, @RequestParam int edad) {
		return "Alumno: " + nombre + " de " + edad + " años. Encontrado!" ;
	}	
	
	@PostMapping("/alumno")
	public Alumno crearAlumno(@RequestBody Alumno alumno) {
		return alumno;	
	}
	
	@PostMapping("/alumnos")
	public String crearAlumnos(@RequestBody Alumno alumno) {
		return "Alumno recibido: " + alumno.getNombre();	
	}
	@PostMapping("/alumnos2")
	public Alumno crearAlumnos2(@RequestBody Alumno alumno) {
		return serviceAlumno.crearAlumno(alumno);	
	}
	
	@PostMapping("/añadir")
	public String addAlumno(@RequestBody Alumno alumno) {
		return serviceAlumno.agregarAlumno(alumno);
	}
	
	@GetMapping("/mostrar")
	public List<Alumno> listar(){
		return serviceAlumno.listarAlumnos();
	}
	
	@GetMapping("/mostrar/{id}")
	public Alumno listarAlumno(@PathVariable int id){
		return serviceAlumno.listarID(id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarAlumno(@PathVariable int id){
		return serviceAlumno.eliminar(id);
	}
	
	@PutMapping("alumno/")
	public String editarAlumno(@RequestBody Alumno a) {
		return serviceAlumno.editarAlumno(a);
		
	}
}