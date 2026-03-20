package sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sb.model.Profesor;
import sb.service.ServiceProfesor;

@RestController
public class ControllerProfesor {
	
	private final ServiceProfesor serviceProfesor;

	public ControllerProfesor(ServiceProfesor serviceProfesor) {
		this.serviceProfesor = serviceProfesor;
	}
	
	@GetMapping("/profesor")
	public Profesor obtenerProfesor() {
		return serviceProfesor.profesor();
	}
	
    @PostMapping("/profesores")
    public String crearProfesor(@RequestBody Profesor profesor) {
        return "Profesor recibido: " + profesor.getNombre()
                + " del módulo " + profesor.getModulo();
    }
}