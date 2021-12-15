package src403.projectFinalPrograWeb.Usuario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class ControllerUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/Crear Usuario")
    public String crearUsuario(Usuario usuario) {

        return "Crear_Usuario";

    }

    @GetMapping("/Guardar Usuario")
    public String guardar(Usuario usuario) {

        usuarioService.guardar(usuario);
        return "redirect:/";

    }

    @GetMapping("/Validar Usuario")
    public String validarUsuario(Usuario usuario, Model model) {

        if (usuarioService.validaUsuario(usuario)) {

            return "redirect:/";

        } else {

            var validacion = false;
            model.addAttribute("validacion", validacion);
            return "Ingresar_Usuario";

        }

    }

    @GetMapping("/Mis Clientes")
    public String listaClientes(Model model) {

        var usuarios = usuarioService.getUsuarios();

        model.addAttribute("usuarios", usuarios);

        return "Mis_Clientes";

    }

    @GetMapping("/Formulario/{id_usuarios}")
    public String formularioCliente(Usuario usuario, Model model) {

        usuario = usuarioService.getUsuario(usuario);

        model.addAttribute("usuario", usuario);
        return "Formulario";

    }

    @GetMapping("/Guardar Formulario")
    public String guardarFormulario(Usuario usuario) {

        usuarioService.guardar(usuario);
        return "redirect:/Mis Clientes";

    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String user(Model model, Usuario usuario) {
        model.addAttribute("user", usuario);
        return "user/info";
    }

//    @RequestMapping(value = "user", method = RequestMethod.GET)
//    public ModelAndView user(Usuario user) {
//        ModelAndView mav = new ModelAndView("user/info");
//        mav.addObject("user", user);
//        return mav;
//    }

    @ModelAttribute("user")
    public Usuario setUser(Usuario user) {

        return user; 

    }

}
