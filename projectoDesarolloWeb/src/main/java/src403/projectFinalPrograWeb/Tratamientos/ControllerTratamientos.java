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

        var tratamiento = tratamientosService.getTratamientosUsuario(id);

        Usuario usuario = new Usuario();
        usuario.setId_usuarios(Long.parseLong(String.valueOf(id_usuario)));

        model.addAttribute("usuario", usuario);
        model.addAttribute("tratamiento", tratamiento);

        return "Tratamientos";

    }

    @GetMapping("/Crear Tratamientos/{id}")
    public String ingresar(Tratamientos tratamientos,@PathVariable("id") long id, Model model) {
        
        Usuario usuario = new Usuario(); 
        usuario.setId_usuarios(id);
        
        model.addAttribute("usuario", usuario);
        
        return "actualizar_tratamientos";
    }

    @GetMapping("/Actualizar Tratamientos")
    public String agregar(Tratamientos tratamientos) {
        return "actualizar_tratamientos";
    }

    @GetMapping("/guardar tratamientos")
    public String guardar(Tratamientos tratamientos) {
        tratamientosService.guardar(tratamientos);
        return "redirect:/";
    }

    @GetMapping("/editar/{id_tratamientos}")
    public String editar(Tratamientos tratamientos, Model model) {
        model.addAttribute("tratamientos", tratamientos);
        return "actualizar_tratamientos";
    }

    @GetMapping("/eliminar/{id_tratamientos}")
    public String eliminar(Tratamientos tratamientos) {
        tratamientosService.eliminar(tratamientos);
        return "redirect:/";
    }

}
