package co.edu.escuelaing.project.AppGusto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.scheduling.support.SimpleTriggerContext;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
//import lombok.Builder;

//@Builder
//@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Utilizamos GenerationType.IDENTITY para autogenerar un número
    @Column(name = "ID_usuario", updatable = false, nullable = false)
    private Long ID_usuario;
    @Column(name = "USERNAME", unique = true, nullable = false, length = 70)
    private String username;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIODOS")
    private String apellidos;
    @Column(name = "CORREO", unique = true, nullable = false ,length = 70)
    private String correo;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA")
    private Date fecha;
    @Column(name = "NUMERO_INICIO_DE_SESION", length = 9)
    private int numero_Inicio_de_sesion;
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Column(name="ACTIVO", columnDefinition = "BOOLEAN")
    private boolean activo;


    //Constructors
    public Usuario() {
    }

    public Usuario(String nombres,
                   String apellidos,
                   String username,
                   String correo,
                   Date fecha, String contrasena) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.correo = correo;
        this.fecha = fecha;
        this.numero_Inicio_de_sesion = 1;
        this.contrasena = contrasena;
        this.activo = true;
    }
    //Methods
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(("USER")));
//    }
//
//    @Override
//    public String getPassword() {
//        return this.contrasena;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.nombre;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }


    //Setters


    public void setUsername(String username) {
        this.username = username;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setID_usuario(Long ID_usuario) {
        this.ID_usuario = ID_usuario;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNumero_Inicio_de_sesion(int numero_Inicio_de_sesion) {
        this.numero_Inicio_de_sesion = numero_Inicio_de_sesion;
    }


    //Getters


    public String getUsername() {
        return username;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public boolean isActivo() {
        return activo;
    }
    public Long getID_usuario() {
        return ID_usuario;
    }


    public String getCorreo() {
        return correo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getNumero_Inicio_de_sesion() {
        return numero_Inicio_de_sesion;
    }

}