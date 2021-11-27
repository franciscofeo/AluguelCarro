package br.com.devhall.DevHall.Controller;

import br.com.devhall.DevHall.DTO.CarroDTO;
import br.com.devhall.DevHall.Model.Carro;
import br.com.devhall.DevHall.Service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;


    @Autowired
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping(path = "/admin/salvar")
    public ResponseEntity<Carro> salvar(@RequestBody CarroDTO carro){
        return carroService.salvar(carro.dtoToCarro());
    }

    @PutMapping(path = "/admin/atualizar/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable Long id,@RequestParam String marca,@RequestParam String modelo){
        return carroService.atualizar(id, marca, modelo);
    }

    @PatchMapping(path = "/admin/attmarca/{id}")
    public ResponseEntity<Carro> atualizarMarca(@PathVariable Long id,@RequestParam String marca){
        return carroService.atualizarMarca(id, marca);
    }

    @PatchMapping(path = "/admin/attmodelo/{id}")
    public ResponseEntity<Carro> atualizarModelo(@PathVariable Long id, @RequestParam String modelo){
        return carroService.atualizarModelo(id, modelo);
    }

    @GetMapping(path = "/buscar/{id}")
    public Carro buscarId(@PathVariable Long id){
        return carroService.buscarId(id);
    }

    @GetMapping(path = "/buscar/todos")
    public Iterable<Carro> listarTodos(@RequestParam int pag){
        return carroService.listarTodos(pag);
    }

    @GetMapping(path = "/buscar/modelo")
    public Iterable<Carro> listarModelos(@RequestParam String modelo){
        return carroService.listarModelo(modelo);
    }

    @GetMapping(path = "/buscar/marca")
    public Iterable<Carro> listarMarcas(@RequestParam String marca){
        return carroService.listarMarca(marca);
    }

    @DeleteMapping(path = "/admin/remover/{id}")
    public ResponseEntity<Carro> deletar(@PathVariable Long id){
        return carroService.deletar(id);
    }

}
