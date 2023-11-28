package co.edu.escuelaing.project.AppGusto.service;

import co.edu.escuelaing.project.AppGusto.model.*;
import co.edu.escuelaing.project.AppGusto.repository.AdministradorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.HttpURLConnection;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;



@Service
public class AdministradorService {
    private final AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService( AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }
    public Administrador addAdministrador(Administrador administrador){return administradorRepository.save(administrador);}
    public List<Administrador> getAdministradores(){
        return administradorRepository.findAll();
    }
    public Optional<Administrador> getAdministradorById(Long id){
        return administradorRepository.findById(id);
    }
    public Administrador updateAdministrador(Administrador administrador){return administradorRepository.save(administrador);}
    public void deleteAdministrador(Long userId) {administradorRepository.deleteById(Long.valueOf(userId));}
}