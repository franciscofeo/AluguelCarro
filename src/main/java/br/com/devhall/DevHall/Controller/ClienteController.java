package br.com.devhall.DevHall.Controller;

import br.com.devhall.DevHall.DTO.ClienteDTO;
import br.com.devhall.DevHall.Model.Cliente;
import br.com.devhall.DevHall.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(path = "/todos")
    public Iterable<Cliente> listarTodos(@RequestParam int pag){
        return clienteService.listarTodos(pag);
    }

    @GetMapping(path = "/buscar/{id}")
    public Cliente listarId(@PathVariable Long id){
        return clienteService.buscarId(id);
    }

    @GetMapping(path = "/buscar/{nome}")
    public Iterable<Cliente> listarNome(@PathVariable String nome){
        return clienteService.buscarNome(nome);
    }

    @GetMapping(path = "/buscar/{cpf}")
    public Iterable<Cliente> listarCpf(@PathVariable String cpf){
        return clienteService.buscarCpf(cpf);
    }

    @PostMapping(path = "/admin/salvar")
    public ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO cliente){
        return clienteService.salvar(cliente.dtoToCLiente());
    }

    @DeleteMapping(path = "/admin/remover/{id}")
    public ResponseEntity<Cliente> deletar(@PathVariable Long id){
        return clienteService.deletar(id);
    }

    @PutMapping(path = "/admin/atualizar/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id,@RequestParam String nome,@RequestParam String cpf,@RequestParam String dataN,@RequestParam Long carroId){
        return clienteService.atualizar(id, nome, cpf, dataN, carroId);
    }

    @PutMapping(path = "/admin/attnome/{id}")
    public ResponseEntity<Cliente> atualizarNome(@PathVariable Long id,@RequestParam String nome){
        return clienteService.atualizarNome(id, nome);
    }

    @PutMapping(path = "/admin/attcpf/{id}")
    public ResponseEntity<Cliente> atualizarCpf(@PathVariable Long id,@RequestParam String cpf){
        return clienteService.atualizarCpf(id, cpf);
    }





}
