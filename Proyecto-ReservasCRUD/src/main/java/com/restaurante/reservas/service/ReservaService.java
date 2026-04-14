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
}