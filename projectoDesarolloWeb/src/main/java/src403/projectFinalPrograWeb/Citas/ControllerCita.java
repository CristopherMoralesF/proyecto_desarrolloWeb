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

    @GetMapping("/Crear Cita/{id_usuarioCita}/{id}/{screen}")
    public String crearCita(Cita cita,@PathVariable("id_usuarioCita") int id_usuarioCita, @PathVariable("id") int id, @PathVariable("screen") String screen, Model model) {

        Usuario usuario = new Usuario();

        usuario.setId_usuarios(Long.parseLong(String.valueOf(id)));
        cita.setId_usuarios(id_usuarioCita);
        
        model.addAttribute("screen",screen);
        model.addAttribute("usuario", usuario);
        model.addAttribute("cita", cita);
        return "actualizar_cita";

    }

    @GetMapping("/Guardar Cita/{id}/{screen}")
    public String guardar(Cita cita, @PathVariable("id") int id, @PathVariable("screen") String screen, Model model) {

        citaService.guardar(cita);
        ControllerUsuario controllerUsuario = new ControllerUsuario();

        if (screen.equals("misClientes")) {

            return "redirect:/Mis Clientes/" + String.valueOf(id); 

        } else {

            return "redirect:/Inicio/" + String.valueOf(id);

        }

    }

    @GetMapping("/Las Citas/{id_usuarios}/{id_usuario}/{screen}")
    public String listaCitas(@PathVariable("id_usuarios") int id, @PathVariable("id_usuario") int id_usuario, @PathVariable("screen") String screen, Model model) {

        var citas = citaService.getCitasUsuario(id);

        Cita cita = new Cita(); 
        cita.setId_usuarios(id);
        Usuario usuario = new Usuario();
        usuario.setId_usuarios(Long.parseLong(String.valueOf(id_usuario)));

        model.addAttribute("cita",cita);
        model.addAttribute("screen", screen);
        model.addAttribute("usuario", usuario);
        model.addAttribute("citas", citas);

        return "lista_cita";

    }

    @GetMapping("/editar/{id_citas}")
    public String editar(Cita cita, Model model) {
        model.addAttribute("cita", cita);
        return "actualizar_cita";
    }

    @GetMapping("/eliminar/{id_citas}/{id}/{screen}")
    public String eliminar(Cita cita, Model model, @PathVariable("id") int id, @PathVariable("screen") String screen) {

        citaService.eliminar(cita);
        return "redirect:/Inicio/" + String.valueOf(id);

    }

}
