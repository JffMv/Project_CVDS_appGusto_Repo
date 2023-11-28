package co.edu.escuelaing.project.AppGusto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "ADMINISTRADOR")
public class Administrador extends Usuario {
    @OneToMany(mappedBy = "admin")
    private ArrayList<Restaurante> restaurantes;

    @Column(name = "NUMERO_RESTAURANTES", length = 9)
    private int numero_Restaurantes;
    @Column(name = "ACTIVO_ADMINISTRADOR", columnDefinition = "BOOLEAN")
    private boolean activoAdministrador;

    //constructor
    public Administrador(String nombre, String correo, Date fecha, String contrasena) {
        super(nombre,correo,fecha,contrasena);
        this.numero_Restaurantes = 0;
        this.restaurantes= new ArrayList<Restaurante>();
    }



    //setters
    public void setNewRestaurante(Restaurante restaurante){
        this.restaurantes.add(restaurante);
    }

    public void setActivoAdministrador(boolean activeAdministrador) {
        this.activoAdministrador = activeAdministrador;
    }

    public void setNumero_Restaurantes(int numero_Restaurantes) {
        this.numero_Restaurantes = numero_Restaurantes;
    }


    //getters
    public boolean isActivoAdministrador() {
        return activoAdministrador;
    }

    public int getNumero_Restaurantes() {
        return numero_Restaurantes;
    }

    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }

}
