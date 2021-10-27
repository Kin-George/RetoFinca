package reto3.finca.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto3.finca.entidades.Client;
import reto3.finca.repositorios.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(Long idClient) {
        return clientRepository.getClient(idClient);
    }

    public Client save(Client client) {
        if (client != null) {
            if (client.getIdClient() != null) {
                Optional<Client> oClient = clientRepository.getClient(client.getIdClient());
                if (oClient.isEmpty()) {
                    return clientRepository.save(client);
                } else {
                    return client;
                }
            } else {
                return clientRepository.save(client);
            }
        }
        return null;
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> oClient= clientRepository.getClient(client.getIdClient());
            if(!oClient.isEmpty()){
                if(client.getName()!=null){
                    oClient.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    oClient.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    oClient.get().setPassword(client.getPassword());
                }
                clientRepository.save(oClient.get());
                return oClient.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(Long idClient) {
        Boolean aBoolean = getClient(idClient).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
