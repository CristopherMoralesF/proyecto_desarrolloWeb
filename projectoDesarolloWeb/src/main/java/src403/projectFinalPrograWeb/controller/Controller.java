package src403.projectFinalPrograWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import src403.projectFinalPrograWeb.Usuario.*;

@org.springframework.stereotype.Controller
@Slf4j
public class Controller {

    @Autowired
    private UsuarioService usuarioService;

    //@ModelAttribute("User") boolean setUser,
    @GetMapping("/")
    public String inicio(Model model) {

        var inicio = "Hello";
        model.addAttribute("inicio", inicio);

        return "index";

    }

    @GetMapping("/Ingresar Usuario")
    public String ingresar(Usuario usuario) {

        return "Ingresar_Usuario";

    }

    @GetMapping("/Servicios/{id}")
    public String servicio(@PathVariable("id") Long id, Model model) {

        if (id > 0) {

            Usuario usuario = new Usuario();
            usuario.setId_usuarios(id);
            usuario = usuarioService.getUsuario(usuario);
            model.addAttribute("usuario", usuario);

        } else {

            Usuario usuario = null;
            model.addAttribute("usuario", usuario);

        }

        return "Servicios";

    }

    @GetMapping("/Contacto/{id}")
    public String contacto(@PathVariable("id") Long id,Model model) {

        if (id > 0) {

            Usuario usuario = new Usuario();
            usuario.setId_usuarios(id);
            usuario = usuarioService.getUsuario(usuario);
            model.addAttribute("usuario", usuario);

        } else {

            Usuario usuario = null;
            model.addAttribute("usuario", usuario);

        }

        return "contacto";

    }

}
