package sb.controller;

import sb.service.ServiceMensaje;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import sb.model.Mensaje;

@RestController
public class ControllerMensaje {
	
	private final ServiceMensaje service;

	public ControllerMensaje(ServiceMensaje service) {
		this.service = service;
	}

	@GetMapping("/")
	public String obtenerSaludo() {
		return service.saludo();
	}

	@GetMapping("/saludo/{nombre}")
	public String saludar(@PathVariable String nombre) {
		return "Hola, " + nombre;
	}

	@GetMapping("/curso/{id}")
	public String curso(@PathVariable int id, @RequestParam String nombre) {
		return "ID: " + id + " Nombre Alumno: " + nombre;
	}

	@GetMapping("/hola/{nombre}")
	public Mensaje hola(@PathVariable String nombre) {
		return service.hola(nombre);
	}

	@GetMapping("/hola")
	public Mensaje obtenerMensaje() {
		return service.mensaje();
	}

	@GetMapping("/saludo")
	public String buscar(@RequestParam String nombre, @RequestParam int edad) {
		return "Hola, " + nombre + " de " + edad + " años";
	}

	@GetMapping("/despedir")
	public String despedida(@RequestParam(required = false) String nombre) {
		if (nombre == null) {
			return "Adiós, anónimo";
		}
		return "Adiós, " + nombre;
	}

	@GetMapping("/despedida")
	public String despedidas(@RequestParam(defaultValue = "anónimo") String nombre) {
		return "Adiós, " + nombre;
	}

	@Value("${app.saludo}")
	private String saludo;

	@Value("${app.autor}")
	private String autor;

	@GetMapping("/config")
	public Mensaje obtenerConfiguracion() {
		return new Mensaje(saludo, autor);
	}

	@PostMapping("/mensajes")
	public String crearMensajes(@RequestBody Mensaje msj) {
		return service.agregarMsj(msj);
	}
	
	@GetMapping("/mensajes")
	public List<Mensaje> obtenerMensajes() {
		return service.listarMensaje();
	}
	
	@PostMapping("/mensaje")
	public Mensaje crearMensaje(@RequestBody Mensaje mensaje) {
		return mensaje;
	}
	
    @PostMapping("/info")
    public String crearInfo(@RequestBody Mensaje mensaje) {
        return "Frase: " + mensaje.getTexto()
                + " de " + mensaje.getAutor();
    }

}