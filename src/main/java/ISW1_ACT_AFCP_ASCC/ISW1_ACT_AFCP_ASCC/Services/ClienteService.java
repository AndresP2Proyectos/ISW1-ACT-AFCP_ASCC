package ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Services;
import ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Model.Cliente;
import ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private  ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
