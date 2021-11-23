package br.com.devhall.DevHall.Controller;

import br.com.devhall.DevHall.DTO.CarroDTO;
import br.com.devhall.DevHall.Model.Carro;
import br.com.devhall.DevHall.Service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping(path = "/todos")
    public Iterable<Carro> listarTodos(){
        return carroService.listarTodos();
    }

    @PostMapping(path = "/salvar")
    public void salvar(@RequestBody CarroDTO carro){
        carroService.salvar(carro.dtoToCarro());
    }
}
