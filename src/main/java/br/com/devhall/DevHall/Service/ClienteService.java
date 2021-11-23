package br.com.devhall.DevHall.Service;

import br.com.devhall.DevHall.Model.Carro;
import br.com.devhall.DevHall.Model.Cliente;
import br.com.devhall.DevHall.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Iterable<Cliente> listarTodos(int pag){
        Pageable pagina = PageRequest.of(pag, 5);
        return clienteRepository.findAll(pagina);
    }

    public Iterable<Cliente> listarNome(String nome){
        return clienteRepository.findByNomeContaining(nome);
    }

    public Cliente buscarId(Long id){
        if(clienteRepository.findById(id).isPresent()){
            return clienteRepository.findById(id).get();
        } else {
            System.out.println("Cliente não encontrado.");
            return null;
        }
    }

    public ResponseEntity<Cliente> salvar(Cliente cliente){
        cliente.setCreated_at(LocalDateTime.now());
        clienteRepository.save(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Cliente> atualizar(Long id, String nome, String cpf, LocalDate dataNascimento, Carro carro){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            Cliente cliente_existente = cliente.get();
            cliente_existente.setUpdated_at(LocalDateTime.now()); // colocando automatico o updated_at
            cliente_existente.setNome(nome);
            cliente_existente.setCpf(cpf);
            cliente_existente.setDataNascimento(dataNascimento);
            cliente_existente.setCarro_alugado(carro);
            clienteRepository.save(cliente_existente);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Cliente> atualizarNome(Long id, String nome){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            Cliente cliente_existente = cliente.get();
            cliente_existente.setUpdated_at(LocalDateTime.now());
            cliente_existente.setNome(nome);
            clienteRepository.save(cliente_existente);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Cliente> atualizarCpf(Long id, String cpf){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            Cliente cliente_existente = cliente.get();
            cliente_existente.setUpdated_at(LocalDateTime.now());
            cliente_existente.setCpf(cpf);
            clienteRepository.save(cliente_existente);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
