package ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tarjeta_usuario")
public class TarjetaUsuario {
    @Id
    @Column(name = "tarjeta_usuario_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tarjeta", nullable = false)
    private TarjetasCredito tarjeta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

}