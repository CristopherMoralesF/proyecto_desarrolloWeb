package src403.projectFinalPrograWeb.Citas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import src403.projectFinalPrograWeb.Usuario.*;

@Controller
@Slf4j
public class ControllerCita {

    @Autowired
    private CitaService citaService;
    private UsuarioService usuarioService; 

    @GetMapping("/Crear Cita/{id}")
    public String crearCita(Cita cita,@PathVariable("id") int id,Model model) {

        cita.setId_usuarios(id);
        model.addAttribute("cita",cita);
        return "actualizar_cita";

    }

    @GetMapping("/Guardar Cita/{id}")
    public String guardar(Cita cita, @PathVariable("id") int id,Model model) {

        citaService.guardar(cita);
        return listaCitas(id,model);

    }

    @GetMapping("/Las Citas/{id_usuarios}")
    public String listaCitas(@PathVariable("id_usuarios") int id, Model model) {

        var citas = citaService.getCitasUsuario(id);

        
        Usuario usuario = new Usuario();
        usuario.setId_usuarios(Long.parseLong(String.valueOf(id)));

        model.addAttribute("usuario",usuario);
        model.addAttribute("citas", citas);

        return "lista_cita";

    }

    @GetMapping("/editar/{id_citas}")
    public String editar(Cita cita, Model model) {
        model.addAttribute("cita", cita);
        return "actualizar_cita";
    }

    @GetMapping("/eliminar/{id_citas}/{id}")
    public String eliminar(Cita cita, Model model,@PathVariable("id") int id) {
        
        citaService.eliminar(cita);
        return listaCitas(id,model);
        
    }

}
