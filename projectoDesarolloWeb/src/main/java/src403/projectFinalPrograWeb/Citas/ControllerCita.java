
package src403.projectFinalPrograWeb.Citas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControllerCita {
    
    
     @Autowired   
private CitaService citaService;

    @GetMapping("/Crear Cita/")
    public String crearCita(Cita cita) {

        return "actualizar_cita";

    }

    @GetMapping("/Guardar Cita")
    public String guardar(Cita cita) {

        citaService.guardar(cita);
        return "redirect:/lista cita";

    }

    
     @GetMapping("/Las Citas/{id_usuarios}")
    public String listaCitas(Model model){
        
        var citas = citaService.getCitas();
        
        model.addAttribute("citas",citas);
        
        return "lista_cita";
        
    }

    @GetMapping("/editar/{id_citas}")
    public String editar(Cita cita, Model model) {
        model.addAttribute("cita", cita);
        return "actualizar_cita";
    }

    @GetMapping("/eliminar/{id_citas}")
    public String eliminar(Cita cita) {
        citaService.eliminar(cita);
        return "redirect:/";
    }

}
