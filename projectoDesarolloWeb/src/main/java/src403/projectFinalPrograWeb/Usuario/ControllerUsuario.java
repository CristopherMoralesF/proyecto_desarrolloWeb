package src403.projectFinalPrograWeb.Usuario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

            usuario = usuarioService.encuentraUsuario(usuario.getCorreo());
            model.addAttribute("usuario", usuario);
            return "Pantalla_Principal";

        } else {

            usuario = null;
            var validacion = false;
            model.addAttribute("usuario", usuario);
            model.addAttribute("validacion", validacion);
            return "Ingresar_Usuario";

        }

    }

    @GetMapping("/Inicio/{id}")
    public String Inicio(@PathVariable("id") Long id, Model model) {

        if (id > 0) {

            Usuario usuario = new Usuario();
            usuario.setId_usuarios(id);
            usuario = usuarioService.getUsuario(usuario);
            model.addAttribute("usuario", usuario);

        } else {

            Usuario usuario = null;
            model.addAttribute("usuario", usuario);

        }
        
        return "Pantalla_Principal";

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

}
