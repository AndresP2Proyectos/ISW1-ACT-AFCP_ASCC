package ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Repository;

import ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
