package co.edu.escuelaing.project.AppGusto.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="GERENTE")
public class Gerente extends Usuario {

    @OneToOne
    @JoinColumn(name = "restaurante_id", unique = true)
    private Restaurante restaurante;

    public Gerente(Restaurante restaurante,String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
        this.restaurante = restaurante;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
