package ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tarjeta_usuario")
@Data
public class TarjetaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // o AUTO, dependiendo de tu DB
    @Column(name = "tarjeta_usuario_id") // este sí se mantiene con snake_case porque es el nombre en BD
    private Integer tarjeta_usuario_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tarjeta", nullable = false)
    private TarjetasCredito tarjeta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

}