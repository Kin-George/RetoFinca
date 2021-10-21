package reto3.finca.repositorios;

import org.springframework.data.repository.CrudRepository;
import reto3.finca.entidades.Messages;

public interface MessageCrudRepository extends CrudRepository<Messages, Long> {

}
