package sb.service;

import org.springframework.stereotype.Service;

import java.util.*;

import sb.model.Alumno;

@Service
public class ServiceAlumno {

	List<Alumno> alumno = new ArrayList<>();
	
	public Alumno crearAlumno(Alumno alumno) {
		return alumno;
	}
	
	public String agregarAlumno(Alumno a) {
		alumno.add(a);
		return "Alumno añadido";
	}
	
	public List<Alumno> listarAlumnos(){
		return alumno;
	}
	
	public Alumno listarID(int id){
		for(Alumno a: alumno) {
			if(a.getId() == id) {
				return a;
			}
		}		
		return null;
	}
	
	public String eliminar(int id){
		for(Alumno a: alumno) {
			if(a.getId() == id) {
				alumno.remove(a);
				return "Alumno '" + a.getNombre() + "' eliminado.";				
			}
		}		
		return "Alumno no encontrado";
	}
	
	public String editarAlumno(Alumno a) {
		for(Alumno alumnos : alumno) {
			if(a.getId() == alumnos.getId()) {
				alumnos.setNombre(a.getNombre());
				return "Alumno editado correctamente";
			}
			
		} return "Error: Alumno no existe";
	}
	
}
