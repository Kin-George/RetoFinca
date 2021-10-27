package reto3.finca.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto3.finca.entidades.Farms;
import reto3.finca.repositorios.FarmRepository;

@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;

    public List<Farms> getAll() {
        return farmRepository.getAll();
    }

    public Optional<Farms> getFarm(Long id) {
        return farmRepository.getFarm(id);
    }

    public Farms save(Farms f) {
        if (f.getId() == null) {
            return farmRepository.save(f);
        } else {
            Optional<Farms> faux = farmRepository.getFarm(f.getId());
            if (faux.isEmpty()) {
                return farmRepository.save(f);
            } else {
                return f;
            }
        }
    }

    public Farms update(Farms f){
        if(f.getId()!=null){
            Optional<Farms> faux=farmRepository.getFarm(f.getId());
            if(!faux.isEmpty()){
                if(f.getName()!=null){
                    faux.get().setName(f.getName());
                }
                if(f.getAddress()!=null){
                    faux.get().setAddress(f.getAddress());
                }
                if(f.getExtension()!=null){
                    faux.get().setExtension(f.getExtension());
                }
                if(f.getDescription()!=null){
                    faux.get().setDescription(f.getDescription());
                }
                if(f.getCategory()!=null){
                    faux.get().setCategory(f.getCategory());
                }
                farmRepository.save(faux.get());
                return faux.get();
            }else{
                return f;
            }
        }else{
            return f;
        }
    }

    public boolean deleteFarm(Long id) {
        Boolean aBoolean = getFarm(id).map(f -> {
            farmRepository.delete(f);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
