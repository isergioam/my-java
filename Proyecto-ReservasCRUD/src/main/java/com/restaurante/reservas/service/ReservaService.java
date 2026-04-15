package com.restaurante.reservas.service;

import com.restaurante.reservas.model.Reserva;
import com.restaurante.reservas.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

	private final ReservaRepository reservaRepository;

	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}

	// Método para mostrar las reservas
	public List<Reserva> listarReservas() {
		return reservaRepository.findAll();
	}

	// Método para guardar reservas
	public Reserva guardarReserva(Reserva reserva) {
		return reservaRepository.save(reserva);
	}

	// Dos métodos para editar las reservas, primero obtenemos su ID
	// y después le inyectamos los nuevos valores. Porque reutilizamos
	// el mismo formulario
	public Reserva obtenerReservaPorId(Long id) {
		return reservaRepository.findById(id).orElse(null);
	}

	public Reserva actualizarReserva(Long id, Reserva reservaActualizada) {
		Reserva reservaExistente = reservaRepository.findById(id).orElse(null);

		if (reservaExistente == null) {
			return null;
		}

		reservaExistente.setNombreCliente(reservaActualizada.getNombreCliente());
		reservaExistente.setTelefono(reservaActualizada.getTelefono());
		reservaExistente.setFechaReserva(reservaActualizada.getFechaReserva());
		reservaExistente.setHoraReserva(reservaActualizada.getHoraReserva());
		reservaExistente.setNumeroPersonas(reservaActualizada.getNumeroPersonas());
		reservaExistente.setNumeroMesa(reservaActualizada.getNumeroMesa());
		reservaExistente.setObservaciones(reservaActualizada.getObservaciones());

		return reservaRepository.save(reservaExistente);
	}

	public boolean eliminarReserva(Long id) {
		Reserva reservaExistente = reservaRepository.findById(id).orElse(null);

		if (reservaExistente == null) {
			return false;
		}

		reservaRepository.deleteById(id);
		return true;
	}
}