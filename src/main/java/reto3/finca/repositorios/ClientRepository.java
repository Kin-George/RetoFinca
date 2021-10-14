package reto3.finca.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.finca.entidades.Client;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientRepository;

    public List<Client> getAll(){
        return (List<Client>) clientRepository.findAll();
    }
    public Optional<Client> getClient(Long id){
        return clientRepository.findById(id);
    }
    public Client save(Client client){
        return clientRepository.save(client);
    }
}
