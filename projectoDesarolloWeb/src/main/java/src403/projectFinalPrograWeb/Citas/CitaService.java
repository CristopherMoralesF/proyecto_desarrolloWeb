package src403.projectFinalPrograWeb.Citas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaService {

    @Autowired
    private CitaDAO citaDAO;

    @Transactional(readOnly = true)
    public List<Cita> getCitas() {

        return (List<Cita>) citaDAO.findAll();

    }

    @Transactional
    public void guardar(Cita cita) {
        citaDAO.save(cita);
    }

    @Transactional
    public void eliminar(Cita cita) {
        citaDAO.delete(cita);
    }

    @Transactional(readOnly = true)
    public Cita getCita(Cita cita) {
        return citaDAO.findById(cita.getId_citas()).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Cita> getCitasUsuario(int id) {

        List<Cita> listaComplete = getCitas();
        ArrayList<Cita> listaFinal = new ArrayList<Cita>(); 

        for (Cita cita : listaComplete) {

            if (cita.getId_usuarios() == id) {

                listaFinal.add(cita);

            }

        }

        return listaFinal;

    }

}
