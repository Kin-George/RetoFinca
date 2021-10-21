package reto3.finca.repositorios;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto3.finca.entidades.Farms;

@Repository
public class FarmRepository {

    @Autowired
    private FarmCrudRepository farmCrudRepository;

    public List<Farms> getAll() {
        return (List<Farms>) farmCrudRepository.findAll();
    }

    public Optional<Farms> getFarm(Long id) {
        return farmCrudRepository.findById(id);
    }

    public Farms save(Farms f) {
        return farmCrudRepository.save(f);
    }
    // public void delete(Finca f){
    // return fincaRepository.delete(f);
    // }
}
