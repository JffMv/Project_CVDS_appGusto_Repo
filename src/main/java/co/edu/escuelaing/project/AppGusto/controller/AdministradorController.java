package co.edu.escuelaing.project.AppGusto.controller;


import co.edu.escuelaing.project.AppGusto.model.Administrador;
import co.edu.escuelaing.project.AppGusto.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    AdministradorService administradorService;

    @GetMapping("/home")
    public String admin(Model model) {
        return "administrador";
    }

    @GetMapping("/register")
    public String mostrarFormularioAgregarAdministrador(Model model){
        model.addAttribute("administrador",new Administrador());
        return "register";
    }

    @PostMapping("/register")
    public String agregarAdministrador(Administrador administrador){
        System.out.println(administrador.toString());
        administradorService.addAdministrador(administrador);
        return "redirect:/administrador/home";
    }

}
