package sb.service;

import org.springframework.stereotype.Service;

import sb.model.Mensaje;

import java.util.*;
@Service
public class ServiceMensaje {
	
	List<Mensaje> msj = new ArrayList<Mensaje>();
	
	public String saludo() {
		return "Hola Mundo!!";
	}
	
	public Mensaje mensaje() {
		return new Mensaje("Hola Mundo!!", "Sergio");
	}
	
	public Mensaje hola(String nombre) {
		return new Mensaje("Hola", nombre);
	}
	
	public String agregarMsj(Mensaje m) {
		msj.add(m);
		return "Mensaje recibido";
	}
	
	public List<Mensaje> listarMensaje(){
		return msj;
	}
	
	
}