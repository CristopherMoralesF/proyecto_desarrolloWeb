package src403.projectFinalPrograWeb.Citas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CitaService {

    @Autowired
    private CitaDAO citaDao;

     
    @Transactional
    public void guardar(Cita cita) {
        citaDao.save(cita);
    }

    @Transactional
    public void eliminar(Cita cita) {
        citaDao.delete(cita);
    }
   
    @Transactional(readOnly = true)
    public Cita getCita(Cita cita) {
        return citaDao.findById(cita.getId_citas()).orElse(null);
       
    }

  

}
