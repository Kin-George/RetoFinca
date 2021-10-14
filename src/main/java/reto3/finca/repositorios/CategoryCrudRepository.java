package reto3.finca.repositorios;

import org.springframework.data.repository.CrudRepository;
import reto3.finca.entidades.Category;


public interface CategoryCrudRepository extends CrudRepository<Category, Long> {
    
}
