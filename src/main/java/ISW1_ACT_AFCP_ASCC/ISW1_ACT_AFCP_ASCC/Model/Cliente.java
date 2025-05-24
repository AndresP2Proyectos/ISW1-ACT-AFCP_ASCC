package ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "cliente_id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @OneToMany(mappedBy = "cliente")
    private Set<TarjetaUsuario> tarjetaUsuarios = new LinkedHashSet<>();

}