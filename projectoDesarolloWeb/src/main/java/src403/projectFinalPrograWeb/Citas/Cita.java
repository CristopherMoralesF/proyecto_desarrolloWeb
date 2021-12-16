
package src403.projectFinalPrograWeb.Citas;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "citas")
   public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_citas;
    private int id_Usuario;
    private String fecha;
    private String hora;
    private String tratamiento;
   
 
}
