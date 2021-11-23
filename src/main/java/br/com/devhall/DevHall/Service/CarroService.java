package br.com.devhall.DevHall.Service;

import br.com.devhall.DevHall.Model.Carro;
import br.com.devhall.DevHall.Repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> listarTodos(){
        return carroRepository.findAll();
    }

    public List<Carro> listarModelo(String modelo){
        return carroRepository.findByModeloContaining(modelo);
    }

    public List<Carro> listarMarca(String marca){
        return carroRepository.findByMarcaContaining(marca);
    }

    public void salvar(Carro carro){
        carroRepository.save(carro);
    }

    public void atualizarModelo(Long id, String modelo){
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent()){
            Carro carro_encontrado = carro.get();
            carro_encontrado.setModelo(modelo);
            carroRepository.save(carro_encontrado);
        }
    }

    public void atualizarMarca(Long id, String marca){
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent()){
            Carro carro_encontrado = carro.get();
            carro_encontrado.setMarca(marca);
            carroRepository.save(carro_encontrado);
        }
    }

    public void atualizar(Long id, String modelo, String marca){
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent()){
            Carro carro_encontrado = carro.get();
            carro_encontrado.setModelo(modelo);
            carro_encontrado.setMarca(marca);
            carroRepository.save(carro_encontrado);
        }
    }

    public void deletar(Long id){
        Optional<Carro> carro = carroRepository.findById(id);
        if(carro.isPresent()){
            carroRepository.delete(carro.get());
        } else {
            System.out.println("Carro não encontrado.");
        }
    }
}
