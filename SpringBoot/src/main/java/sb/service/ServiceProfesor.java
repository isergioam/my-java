package sb.service;

import org.springframework.stereotype.Service;

import sb.model.Profesor;

@Service
public class ServiceProfesor {

	public Profesor profesor() {
		return new Profesor("Sergio", "Programación", 500);
	}
}