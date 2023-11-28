package co.edu.escuelaing.project.AppGusto.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="GERENTE")
public class Gerente extends Usuario {

    @OneToOne
    @JoinColumn(name = "ID_RESTAURANTE", referencedColumnName = "ID_RESTAURANTE")
    private Restaurante ID_restaurante;

    public Gerente(Restaurante restaurante,String nombre, String correo, Date fecha, String contrasena) {
        super(nombre, correo, fecha, contrasena);
        this.ID_restaurante = restaurante;
    }

    public Restaurante getID_restaurante() {
        return ID_restaurante;
    }

    public void setID_restaurante(Restaurante ID_restaurante) {
        this.ID_restaurante = ID_restaurante;
    }
}
