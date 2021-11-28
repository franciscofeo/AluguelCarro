package br.com.devhall.DevHall.Controller;

import br.com.devhall.DevHall.DTO.CarroClienteDTO;
import br.com.devhall.DevHall.Model.CarroCliente;
import br.com.devhall.DevHall.Service.CarroClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carroscliente")
public class CarroClienteController {

    private final CarroClienteService carroClienteService;


    @Autowired
    public CarroClienteController(CarroClienteService carroClienteService) {
        this.carroClienteService = carroClienteService;
    }


    @PutMapping(path = "/admin/atualizar/{id}")
    public ResponseEntity<CarroCliente> atualizar(@PathVariable Long id, @RequestParam String marca, @RequestParam String modelo){
        return carroClienteService.atualizar(id, marca, modelo);
    }

    @PatchMapping(path = "/admin/attmarca/{id}")
    public ResponseEntity<CarroCliente> atualizarMarca(@PathVariable Long id, @RequestParam String marca){
        return carroClienteService.atualizarMarca(id, marca);
    }

    @PatchMapping(path = "/admin/attmodelo/{id}")
    public ResponseEntity<CarroCliente> atualizarModelo(@PathVariable Long id, @RequestParam String modelo){
        return carroClienteService.atualizarModelo(id, modelo);
    }

    @GetMapping(path = "/buscar/{id}")
    public CarroCliente buscarId(@PathVariable Long id){
        return carroClienteService.buscarId(id);
    }

    @GetMapping(path = "/buscar/todos")
    public Iterable<CarroCliente> listarTodos(@RequestParam int pag){
        return carroClienteService.listarTodos(pag);
    }

    @GetMapping(path = "/buscar/modelo")
    public Iterable<CarroCliente> listarModelos(@RequestParam String modelo){
        return carroClienteService.listarModelo(modelo);
    }

    @GetMapping(path = "/buscar/marca")
    public Iterable<CarroCliente> listarMarcas(@RequestParam String marca){
        return carroClienteService.listarMarca(marca);
    }

    @DeleteMapping(path = "/admin/remover/{id}")
    public ResponseEntity<CarroCliente> deletar(@PathVariable Long id){
        return carroClienteService.deletar(id);
    }

}
