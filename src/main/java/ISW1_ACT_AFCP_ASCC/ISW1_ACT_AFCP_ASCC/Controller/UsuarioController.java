package ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Controller;
import ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Model.Cliente;
import ISW1_ACT_AFCP_ASCC.ISW1_ACT_AFCP_ASCC.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class UsuarioController {

    private final ClienteService clienteService;

    @Autowired
    public UsuarioController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @CrossOrigin(origins = "http://localhost:5174")
    @PostMapping("/crear")
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cliente) {
        Cliente clienteGuardado = clienteService.guardarCliente(cliente);
        return ResponseEntity.ok("El cliente " + clienteGuardado.getNombre() + " fue guardado correctamente.");
    }

}
