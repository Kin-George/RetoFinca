package reto3.finca.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import reto3.finca.entidades.Category;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(Long id) {
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category c) {
        return categoryCrudRepository.save(c);
    }
}
