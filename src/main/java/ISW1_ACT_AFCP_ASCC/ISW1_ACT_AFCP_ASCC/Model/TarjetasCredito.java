package ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tarjetas_credito")
public class TarjetasCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarjeta_id")
    private Integer tarjeta_id;

    @Column(name = "numero", length = 16)
    private String numero;

    @Column(name = "fecha_vencimiento", length = 7)
    private String fechaVencimiento;

    @Column(name = "franquicia", length = 20)
    private String franquicia;

    @ColumnDefault("ACTIVO")
    @Column(name = "estado", length = 10)
    private String estado;

    @Column(name = "cupo_total", precision = 10, scale = 2)
    private BigDecimal cupoTotal;

    @Column(name = "cupo_disponible", precision = 10, scale = 2)
    private BigDecimal cupoDisponible;

    @Column(name = "cupo_utilizado", precision = 10, scale = 2)
    private BigDecimal cupoUtilizado;

}