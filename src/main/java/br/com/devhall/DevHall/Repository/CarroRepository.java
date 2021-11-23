package br.com.devhall.DevHall.Repository;

import br.com.devhall.DevHall.Model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByModeloContaining(String modelo);
    List<Carro> findByMarcaContaining(String marca);
}
