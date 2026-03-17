package model;

import jakarta.persistence.*;

/**
 * Entidad que representa un empleado.
 */
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    private int id;

    @Column(nullable = false, length = 100)
    private String nombre;

    /**
     * Relación muchos a uno:
     * muchos empleados pueden pertenecer a un departamento.
     *
     * JoinColumn indica la columna de clave foránea.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setDepartamento(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", nombre='" + nombre + "'}";
    }
}