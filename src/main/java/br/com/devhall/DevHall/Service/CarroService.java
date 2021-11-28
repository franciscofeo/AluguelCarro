package br.com.devhall.DevHall.Service;


import br.com.devhall.DevHall.Model.Carro;
import br.com.devhall.DevHall.Repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    @Autowired
    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }


    public Iterable<Carro> listarTodos(int pag){
        Pageable pagina = PageRequest.of(pag, 5);
        return carroRepository.findAll(pagina);
    }

    public Carro buscarId(Long id){
        if(carroRepository.findById(id).isPresent()){
            return carroRepository.findById(id).get();
        } else {
            System.out.println("Carro não encontrado.");
            return null;
        }
    }

    public List<Carro> listarModelo(String modelo){
        return carroRepository.findByModeloContaining(modelo);
    }

    public Carro listarModeloExato(String modelo){
        return carroRepository.findByModeloIs(modelo);
    }

    public List<Carro> listarMarca(String marca){
        return carroRepository.findByMarcaContaining(marca);
    }


    public ResponseEntity<Carro> salvar(Carro carroCliente){
        carroRepository.save(carroCliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Carro> atualizarModelo(Long id, String modelo){
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent()){
            Carro carro_Cliente_encontrado = carro.get();
            carro_Cliente_encontrado.setModelo(modelo);
            carroRepository.save(carro_Cliente_encontrado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Carro> atualizarMarca(Long id, String marca){
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent()){
            Carro carro_Cliente_encontrado = carro.get();
            carro_Cliente_encontrado.setMarca(marca);
            carroRepository.save(carro_Cliente_encontrado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Carro> atualizar(Long id, String modelo, String marca){
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent()){
            Carro carro_Cliente_encontrado = carro.get();
            carro_Cliente_encontrado.setModelo(modelo);
            carro_Cliente_encontrado.setMarca(marca);
            carroRepository.save(carro_Cliente_encontrado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Carro> deletar(Long id){
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent()){
            carroRepository.delete(carro.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
