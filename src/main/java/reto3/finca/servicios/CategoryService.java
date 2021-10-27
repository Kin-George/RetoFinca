package reto3.finca.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import reto3.finca.repositorios.CategoryRepository;
import reto3.finca.entidades.Category;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(Long id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category f) {
        if (f.getId() == null) {
            return categoryRepository.save(f);
        } else {
            Optional<Category> faux = categoryRepository.getCategory(f.getId());
            if (faux.isEmpty()) {
                return categoryRepository.save(f);
            } else {
                return f;
            }
        }
    }

    public Category update(Category f){
        if(f.getId()!=null){
            Optional<Category>g=categoryRepository.getCategory(f.getId());
            if(!g.isEmpty()){
                if(f.getName()!=null){
                    g.get().setName(f.getName());
                }
                if(f.getDescription()!=null){
                    g.get().setDescription(f.getDescription());
                }
                return categoryRepository.save(g.get());
            }
        }
        return f;
    }

    public boolean deleteCategory(Long idCategory){
        Boolean d=getCategory(idCategory).map(categoria -> {
            categoryRepository.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
