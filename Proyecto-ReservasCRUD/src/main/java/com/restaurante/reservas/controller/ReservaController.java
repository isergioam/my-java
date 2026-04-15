package com.restaurante.reservas.controller;

import com.restaurante.reservas.model.Reserva;
import com.restaurante.reservas.service.ReservaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> obtenerReservas() {
        return reservaService.listarReservas();
    }
    
    @GetMapping("/{id}")
    public Reserva obtenerReservaPorId(@PathVariable Long id) {
        return reservaService.obtenerReservaPorId(id);
    }
    
    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaService.guardarReserva(reserva);
    }
    
    @PutMapping("/{id}")
    public Reserva editarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaService.actualizarReserva(id, reserva);
    }
    
    @DeleteMapping("/{id}")
    public boolean borrarReserva(@PathVariable Long id) {
        return reservaService.eliminarReserva(id);
    }
    
}