package br.com.devhall.DevHall.Repository;

import br.com.devhall.DevHall.Model.CarroCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroClienteRepository extends JpaRepository<CarroCliente, Long> {

    List<CarroCliente> findByModeloContaining(String modelo);
    List<CarroCliente> findByMarcaContaining(String marca);
}
