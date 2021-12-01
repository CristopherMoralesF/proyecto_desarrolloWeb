package src403.projectFinalPrograWeb.Usuario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String validarUsuario(Usuario usuario,Model model){
        
        if (usuarioService.validaUsuario(usuario)) {
            
            return "Pantalla_Principal";
            
        } else {
            
            var validacion = false; 
            model.addAttribute("validacion",validacion);
            return "Ingresar_Usuario";
            
        }
        
        
        
    }
 
}
