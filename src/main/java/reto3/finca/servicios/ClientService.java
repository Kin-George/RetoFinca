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
}
