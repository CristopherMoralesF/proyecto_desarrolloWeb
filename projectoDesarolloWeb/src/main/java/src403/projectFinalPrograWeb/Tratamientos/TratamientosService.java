package src403.projectFinalPrograWeb.Tratamientos;

import java.util.ArrayList;
import src403.projectFinalPrograWeb.Tratamientos.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TratamientosService {

    @Autowired
    private TratamientosDAO tratamientosDao;

    @Transactional
    public void guardar(Tratamientos tratamientos) {
        tratamientosDao.save(tratamientos);
    }

    @Transactional
    public void eliminar(Tratamientos tratamientos) {
        tratamientosDao.delete(tratamientos);
    }

    @Transactional(readOnly = true)
    public Tratamientos getTratamientos(Tratamientos tratamientos) {
        return tratamientosDao.findById(tratamientos.getId_tratamientos()).orElse(null);

    }

    @Transactional(readOnly = true)
    public List<Tratamientos> getTratamientos() {

        return (List<Tratamientos>) tratamientosDao.findAll();

    }

    @Transactional(readOnly = true)
    public List<Tratamientos> getTratamientosUsuario(int id) {

        List<Tratamientos> listaCompleta = getTratamientos();
        ArrayList<Tratamientos> listaFinal = new ArrayList<Tratamientos>();

        for (Tratamientos tratamiento : listaCompleta) {

            if (tratamiento.getId_Usuario() == id) {
                listaFinal.add(tratamiento);
            }

        }

        return listaFinal;

    }

}
