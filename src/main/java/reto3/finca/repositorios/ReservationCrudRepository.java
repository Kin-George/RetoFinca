package reto3.finca.repositorios;

import org.springframework.data.repository.CrudRepository;
import reto3.finca.entidades.Reservations;

public interface ReservationCrudRepository extends CrudRepository<Reservations, Long> {
    
}
