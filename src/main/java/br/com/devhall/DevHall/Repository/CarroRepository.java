package br.com.devhall.DevHall.Repository;

import br.com.devhall.DevHall.Model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByModeloContaining(String modelo);
    List<Carro> findByMarcaContaining(String marca);
    Carro findByModeloIs(String modelo);
}
