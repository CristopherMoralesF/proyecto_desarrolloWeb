package src403.projectFinalPrograWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import src403.projectFinalPrograWeb.Usuario.*;

@org.springframework.stereotype.Controller
@Slf4j
public class Controller {

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

    @GetMapping("/Servicios")
    public String servicio() {

        return "Servicios";

    }

}
