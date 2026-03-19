package sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sb.model.Profesor;
import sb.service.ServicePruebas;

@RestController
public class ControllerProfesor {
	
	private final ServicePruebas service;

	public ControllerProfesor(ServicePruebas service) {
		this.service = service;
	}
	
	@GetMapping("/profesor")
	public Profesor obtenerProfesor() {
		return service.profesor();
	}

}
