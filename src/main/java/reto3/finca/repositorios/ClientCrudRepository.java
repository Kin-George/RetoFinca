package reto3.finca.repositorios;

import org.springframework.data.repository.CrudRepository;
import reto3.finca.entidades.Client;

public interface ClientCrudRepository extends CrudRepository<Client, Long> {
    
}
