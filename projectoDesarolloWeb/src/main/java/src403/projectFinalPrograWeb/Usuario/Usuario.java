package src403.projectFinalPrograWeb.Usuario;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuarios;
    private String nombre;
    private String apellidos;
    private String edad;
    private String Correo;
    private String contraseña;
    private String motivo_consulta; 
    private String problemas_cardiacos; 
    private String transtornos_sangrado; 
    private String enfermedad_infecciosas; 
    private String alergias; 
    private String operaciones; 
    private String transfusiones_transplantes; 
    

}
