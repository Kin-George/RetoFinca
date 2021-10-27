package reto3.finca.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import reto3.finca.repositorios.MessageRepository;
import reto3.finca.entidades.Messages;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Messages> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Messages> getMessage(Long idMessage) {
        return messageRepository.getMessage(idMessage);
    }

    public Messages save(Messages m) {
        if (m.getIdMessage() == null) {
            return messageRepository.save(m);
        } else {
            Optional<Messages> maux = messageRepository.getMessage(m.getIdMessage());
            if (maux.isEmpty()) {
                return messageRepository.save(m);
            } else {
                return m;
            }
        }
    }

    public Messages update(Messages m){
        if(m.getIdMessage()!=null){
            Optional<Messages> maux= messageRepository.getMessage(m.getIdMessage());
            if(!maux.isEmpty()){
                if(m.getMessageText()!=null){
                    maux.get().setMessageText(m.getMessageText());
                }
                messageRepository.save(maux.get());
                return maux.get();
            }else{
                return m;
            }
        }else{
            return m;
        }
    }

    public boolean deleteMessage(Long idMessage) {
        Boolean aBoolean = getMessage(idMessage).map(m -> {
            messageRepository.delete(m);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
