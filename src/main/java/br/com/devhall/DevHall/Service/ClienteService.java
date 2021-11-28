package br.com.devhall.DevHall.Service;

import br.com.devhall.DevHall.Model.Cliente;
import br.com.devhall.DevHall.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final CarroService carroService;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, CarroService carroService) {
        this.clienteRepository = clienteRepository;
        this.carroService = carroService;
    }


    public Iterable<Cliente> listarTodos(int pag){
        Pageable pagina = PageRequest.of(pag, 5);
        return clienteRepository.findAll(pagina);
    }

    public Iterable<Cliente> buscarNome(String nome){
        return clienteRepository.findByNomeContaining(nome);
    }

    @Cacheable(cacheNames = "Cliente", key = "#id")
    public Cliente buscarId(Long id){
        if(clienteRepository.findById(id).isPresent()){
            return clienteRepository.findById(id).get();
        } else {
            System.out.println("Cliente não encontrado.");
            return null;
        }
    }

    public Iterable<Cliente> buscarCpf(String cpf){
        return clienteRepository.findByCpfContaining(cpf);
    }

    @CacheEvict(cacheNames = "Cliente", allEntries = true)
    @Transactional
    public ResponseEntity<Cliente> salvar(Cliente cliente){
        clienteRepository.save(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Cliente> atualizar(Long id, String nome, String cpf, String dataN, Long carroID){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            Cliente cliente_existente = cliente.get();

            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("d/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(dataN, formatador);

            cliente_existente.setNome(nome);
            cliente_existente.setCpf(cpf);
            cliente_existente.setDataNascimento(dataNascimento);
            cliente_existente.setCarroAlugado(carroService.buscarId(id));

            return salvar(cliente_existente);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Cliente> atualizarNome(Long id, String nome){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            Cliente cliente_existente = cliente.get();
            cliente_existente.setNome(nome);
            return salvar(cliente_existente);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Cliente> atualizarCpf(Long id, String cpf){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            Cliente cliente_existente = cliente.get();
            cliente_existente.setCpf(cpf);
            return salvar(cliente_existente);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @CacheEvict(cacheNames = "Cliente", key = "#id")
    public ResponseEntity<Cliente> deletar(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            Cliente cliente_existente = cliente.get();
            clienteRepository.delete(cliente_existente);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
