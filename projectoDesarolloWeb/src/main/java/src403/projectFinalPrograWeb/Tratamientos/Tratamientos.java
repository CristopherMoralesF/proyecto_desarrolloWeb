
package src403.projectFinalPrograWeb.Tratamientos;

import src403.projectFinalPrograWeb.Tratamientos.*;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tratamiento")
   public class Tratamientos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tratamientos;
    private int id_Usuario;
    private String nombre;
    private int duracion;
    private int precio;
   
 
}
