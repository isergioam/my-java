package model;

import jakarta.persistence.*;

/**
 * Entidad que representa un empleado.
 */
@Entity
@Table(name = "empleados")
public class Empleado {

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
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public Empleado() {
    }

    public Empleado(int id, String nombre) {
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{id=" + id + ", nombre='" + nombre + "'}";
    }
}