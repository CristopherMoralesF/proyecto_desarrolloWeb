package src403.projectFinalPrograWeb.Tratamientos;

import src403.projectFinalPrograWeb.Tratamientos.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import src403.projectFinalPrograWeb.Usuario.*;

@Controller
@Slf4j
public class ControllerTratamientos {

    @Autowired
    private TratamientosService tratamientosService;

    @GetMapping("/Tratamientos/{id_usuarios}/{id_usuario}")
    public String listaTratamientos(@PathVariable("id_usuarios") int id,@PathVariable("id_usuario") int id_usuario, Model model) {

        var tratamientos = tratamientosService.getTratamientosUsuario(id);

        Usuario usuario = new Usuario();
        usuario.setId_usuarios(Long.parseLong(String.valueOf(id_usuario)));
        Tratamientos tratamiento = new Tratamientos(); 
        tratamiento.setId_Usuario(id);
        
        
        model.addAttribute("tratamiento",tratamiento);
        model.addAttribute("usuario", usuario);
        model.addAttribute("tratamientos", tratamientos);

        return "Tratamientos";

    }

    @GetMapping("/Crear Tratamientos/{id}/{id_log}")
    public String ingresar(Tratamientos tratamientos,@PathVariable("id") int id,@PathVariable("id_log") int id_log, Model model) {
        
        Usuario usuario = new Usuario(); 
        usuario.setId_usuarios(Long.parseLong(String.valueOf(id_log)));
        
        tratamientos.setId_Usuario(id);
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("tratamientos",tratamientos);
        
        return "actualizar_tratamientos";
    }

    @GetMapping("/Actualizar Tratamientos")
    public String agregar(Tratamientos tratamientos) {
        return "actualizar_tratamientos";
    }

    @GetMapping("/guardar tratamientos/{id}/{id_Usuario}")
    public String guardar(Tratamientos tratamientos,@PathVariable("id") int id, @PathVariable("id_Usuario") int id_Usuario) {
        tratamientosService.guardar(tratamientos);
        return "redirect:/Tratamientos/" + String.valueOf(id) + "/" + String.valueOf(id_Usuario);
    }

    @GetMapping("/editar/{id_tratamientos}/{id_usuario}")
    public String editar(Tratamientos tratamientos, Model model) {
        model.addAttribute("tratamientos", tratamientos);
        return "actualizar_tratamientos";
    }

    @GetMapping("/Eliminar Tratamiento/{id_tratamientos}/{id_usuario}/{id_usuariolog}")
    public String eliminar(Tratamientos tratamientos,@PathVariable("id_usuario") int id_usuario,@PathVariable("id_usuariolog") int id_usuariolog) {
        tratamientosService.eliminar(tratamientos);
        return "redirect:/Tratamientos/" + id_usuario + "/" + String.valueOf(id_usuariolog);
    }

}
