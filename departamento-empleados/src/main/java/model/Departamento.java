package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un departamento.
 */
@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    private int id;

    @Column(nullable = false, length = 100)
    private String nombre;

    /**
     * Relación uno a muchos:
     * un departamento puede tener muchos empleados.
     *
     * mappedBy indica que la relación se gestiona
     * desde el atributo "departamento" de Empleado.
     */
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Empleado> empleados = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(int id, String nombre) {
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Método de ayuda para mantener la relación sincronizada
     * en memoria por ambos lados.
     */
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setDepartamento(this);
    }

    @Override
    public String toString() {
        return "Departamento{id=" + id + ", nombre='" + nombre + "'}";
    }
}
