package br.com.devhall.DevHall.Service;

import br.com.devhall.DevHall.Model.CarroCliente;
import br.com.devhall.DevHall.Repository.CarroClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroClienteService {

    private final CarroClienteRepository carroClienteRepository;

    @Autowired
    public CarroClienteService(CarroClienteRepository carroClienteRepository) {
        this.carroClienteRepository = carroClienteRepository;
    }


    public Iterable<CarroCliente> listarTodos(int pag){
        Pageable pagina = PageRequest.of(pag, 5);
        return carroClienteRepository.findAll(pagina);
    }

    public CarroCliente buscarId(Long id){
        if(carroClienteRepository.findById(id).isPresent()){
            return carroClienteRepository.findById(id).get();
        } else {
            System.out.println("Carro não encontrado.");
            return null;
        }
    }

    public List<CarroCliente> listarModelo(String modelo){
        return carroClienteRepository.findByModeloContaining(modelo);
    }

    public List<CarroCliente> listarMarca(String marca){
        return carroClienteRepository.findByMarcaContaining(marca);
    }


    public ResponseEntity<CarroCliente> salvar(CarroCliente carroCliente){
        carroClienteRepository.save(carroCliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<CarroCliente> atualizarModelo(Long id, String modelo){
        Optional<CarroCliente> carro = carroClienteRepository.findById(id);
        if(carro.isPresent()){
            CarroCliente carro_Cliente_encontrado = carro.get();
            carro_Cliente_encontrado.setModelo(modelo);
            carroClienteRepository.save(carro_Cliente_encontrado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<CarroCliente> atualizarMarca(Long id, String marca){
        Optional<CarroCliente> carro = carroClienteRepository.findById(id);
        if(carro.isPresent()){
            CarroCliente carro_Cliente_encontrado = carro.get();
            carro_Cliente_encontrado.setMarca(marca);
            carroClienteRepository.save(carro_Cliente_encontrado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<CarroCliente> atualizar(Long id, String modelo, String marca){
        Optional<CarroCliente> carro = carroClienteRepository.findById(id);
        if(carro.isPresent()){
            CarroCliente carro_Cliente_encontrado = carro.get();
            carro_Cliente_encontrado.setModelo(modelo);
            carro_Cliente_encontrado.setMarca(marca);
            carroClienteRepository.save(carro_Cliente_encontrado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<CarroCliente> deletar(Long id){
        Optional<CarroCliente> carro = carroClienteRepository.findById(id);
        if(carro.isPresent()){
            carroClienteRepository.delete(carro.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
