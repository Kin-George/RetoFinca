package reto3.finca.repositorios;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto3.finca.entidades.Messages;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Messages> getAll(){
        return (List<Messages>) messageCrudRepository.findAll();
    }

    public Optional<Messages> getMessage(Long idMessage){
        return messageCrudRepository.findById(idMessage);
    }

    public Messages save(Messages m){
        return messageCrudRepository.save(m);
    }
}
