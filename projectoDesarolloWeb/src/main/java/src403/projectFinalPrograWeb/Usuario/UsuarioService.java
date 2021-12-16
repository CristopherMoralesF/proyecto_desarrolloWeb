package src403.projectFinalPrograWeb.Usuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {

        return (List<Usuario>) usuarioDAO.findAll();

    }

    @Transactional
    public void guardar(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Transactional
    public void eliminar(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDAO.findById(usuario.getId_usuarios()).orElse(null);
    }

    //Valida si el usuario existe en la base de datos. 
    public boolean validaUsuario(Usuario usuario) {

        //recopila la información de todos los usuarios
        Usuario usuarioEncontrado = null;
        List<Usuario> misUsuarios = getUsuarios();

        //Valida si existe el usuario que se ingreso en el sistema. 
        for (Usuario miUsuario : misUsuarios) {

            if (miUsuario.getCorreo().equalsIgnoreCase(usuario.getCorreo())) {
                usuarioEncontrado = miUsuario;
                break;
            }

        }

        //Se valida si se encontró el usuario y si la contraseña es correcta. 
        if (usuarioEncontrado == null) {
            return false;
        } else {

            if (usuarioEncontrado.getContraseña().equals(usuario.getContraseña())) {
                return true;
            } else {
                return false;
            }

        }

    }

    public Usuario encuentraUsuario(String nombreUsuario) {

        Usuario usuarioEncontrado = null;
        List<Usuario> misUsuarios = getUsuarios();

        for (Usuario miUsuario : misUsuarios) {

            if (miUsuario.getCorreo().equalsIgnoreCase(nombreUsuario)) {

                usuarioEncontrado = miUsuario;
                break;

            }

        }

        return usuarioEncontrado;

    }

}
