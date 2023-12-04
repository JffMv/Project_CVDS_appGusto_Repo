package co.edu.escuelaing.project.AppGustoTest;


import co.edu.escuelaing.project.AppGusto.dto.UserDto;
import co.edu.escuelaing.project.AppGusto.model.Administrador;
import co.edu.escuelaing.project.AppGusto.model.Comensal;
import co.edu.escuelaing.project.AppGusto.model.GerenteDelAdministrador;
import co.edu.escuelaing.project.AppGusto.repository.*;
import co.edu.escuelaing.project.AppGusto.service.UserServiceImpl;
import co.edu.escuelaing.project.AppGusto.service.UsuariosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.SpringVersion;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AppGustoTest {
    @InjectMocks
    UsuariosService usuariosService;

    @InjectMocks
    UserServiceImpl userServiceImpl;
    @Mock
    UserRepository userRepository;
    @Mock
    AdministradorRepository administradorRepository;
    @Mock
    GerenteRepository gerenteRepository;
    @Mock
    ComensalRepository comensalRepository;
    @Mock
    RoleRepository roleRepository;
    @Mock
    @MockBean
    PasswordEncoder passwordEncoder;

    private UserDto userDtoTestService;

    private UserDto userDto;

    private Administrador administrador;

    private Comensal comensal;

    private GerenteDelAdministrador gerente;


    @BeforeEach
    public void setup(){
        userDtoTestService = UserDto.builder()
                .id(1L)
                .firstName("Juan")
                .lastName("Camargo")
                .email("juancamargo@mail.com")
                .password("Dev123")
                .build();

        userDto = UserDto.builder()
                .id(1L)
                .firstName("Juan")
                .lastName("Camargo")
                .email("juancamargo@mail.com")
                .password("Dev123")
                .build();

        administrador=userServiceImpl.saveAdministrador(userDto);
        gerente=userServiceImpl.saveGerente(userDto);
        comensal=userServiceImpl.saveComensal(userDto);
    }

    @DisplayName("Crear un administrador no resgistrado")
    @Test
    public void crearAdminNoResgistrado_thenReturnAdministradorObject(){
        // given - precondition or setup
        Administrador administrador;
        administrador = userServiceImpl.saveAdministrador(userDtoTestService);
        // when -  action or the behaviour that we are going test
        when(usuariosService.getAdministrador(administrador.getId())).thenReturn(administrador);
        // then - verify the output
        Administrador saveAdministrador = usuariosService.getAdministrador(administrador.getId());
        assertThat(saveAdministrador).isNotNull();
    }

    @DisplayName("Crear un comensal no resgistrado")
    @Test
    public void crearComensalNoResgistrado_thenReturnComensalObject(){
        // given - precondition or setup
        Comensal comensal;
        comensal = userServiceImpl.saveComensal(userDtoTestService);
        // when -  action or the behaviour that we are going test
        when(usuariosService.getComensal(comensal.getId())).thenReturn(comensal);
        // then - verify the output
        Comensal saveComensal = usuariosService.getComensal(comensal.getId());
        assertThat(saveComensal).isNotNull();
    }

    @DisplayName("Crear un gerente no resgistrado")
    @Test
    public void crearGerenteNoResgistrado_thenReturnGerenteObject(){
        // given - precondition or setup
        GerenteDelAdministrador gerenteDelAdministrador;
        gerenteDelAdministrador = userServiceImpl.saveGerente(userDtoTestService);
        // when -  action or the behaviour that we are going test
        when(usuariosService.getGerente(gerenteDelAdministrador.getId())).thenReturn(gerenteDelAdministrador);
        // then - verify the output
        GerenteDelAdministrador saveGerente = usuariosService.getGerente(gerenteDelAdministrador.getId());
        assertThat(saveGerente).isNotNull();
    }


}