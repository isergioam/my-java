package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un departamento.
 */
@Entity
@Table(name = "clientes")
public class Cliente {

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
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int id, String nombre) {
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * Método de ayuda para mantener la relación sincronizada
     * en memoria por ambos lados.
     */
    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.setDepartamento(this);
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "'}";
    }
}
