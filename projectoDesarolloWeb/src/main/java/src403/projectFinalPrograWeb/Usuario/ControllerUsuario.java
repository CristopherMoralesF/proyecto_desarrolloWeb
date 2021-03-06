package src403.projectFinalPrograWeb.Usuario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/Mis Clientes/{id}")
    public String listaClientes(Model model, @PathVariable("id") int id) {

        Usuario usuario = new Usuario();
        usuario.setId_usuarios(Long.parseLong(String.valueOf(id)));
        var usuarios = usuarioService.getUsuarios();

        model.addAttribute("usuario", usuario);
        model.addAttribute("usuarios", usuarios);

        return "Mis_Clientes";

    }

    @GetMapping("/Formulario/{id_usuarios}/{id}/{screen}")
    public String formularioCliente(Usuario usuario, Model model, @PathVariable("id") int id,@PathVariable("screen") String screen) {

        usuario = usuarioService.getUsuario(usuario);
        Usuario usuarioLog = new Usuario();
        usuarioLog.setId_usuarios(Long.parseLong(String.valueOf(id)));
        
        model.addAttribute("screen",screen);
        model.addAttribute("usuario", usuarioLog);
        model.addAttribute("usuarioForm", usuario);
        return "Formulario";

    }

    @GetMapping("/Guardar Formulario/{id}/{screen}")
    public String guardarFormulario(Usuario usuario, @PathVariable("id") int id, @PathVariable("screen") String screen, Model model) {

        usuarioService.guardar(usuario);

        if (screen.equalsIgnoreCase("misClientes")) {

            return listaClientes(model, id);

        } else {

            return Inicio(Long.parseLong(String.valueOf(id)), model);

        }

    }

}
