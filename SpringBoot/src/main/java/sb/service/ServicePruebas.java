package sb.service;

import org.springframework.stereotype.Service;

import sb.model.Mensaje;
import sb.model.Profesor;

@Service
public class ServicePruebas {
	
	public String saludo() {
		return "Hola Mundo!!";
	}
	
	public Mensaje mensaje() {
		return new Mensaje("Hola Mundo!!", "Sergio");
	}
	
	public Mensaje hola(String nombre) {
		return new Mensaje("Hola", nombre);
	}
	
	public Profesor profesor() {
		return new Profesor("Sergio", "Programación");
	}

}
