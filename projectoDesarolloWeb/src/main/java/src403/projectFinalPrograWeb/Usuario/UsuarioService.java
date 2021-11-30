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

}
