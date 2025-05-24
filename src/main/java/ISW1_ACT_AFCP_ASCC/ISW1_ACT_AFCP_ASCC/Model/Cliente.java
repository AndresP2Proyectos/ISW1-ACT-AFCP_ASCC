package ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer cliente_id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "correo", length = 50)
    private String correo;

    @Column(name = "telefono", length = 50)
    private String telefono;


}