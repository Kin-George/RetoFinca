package reto3.finca.Controladores;

import reto3.finca.servicios.MessageService;
import reto3.finca.entidades.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Messages> getMessages() {
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Messages> getMessage(@PathVariable("id") Long idMessage) {
        return messageService.getMessage(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages save(@RequestBody Messages message) {
        return messageService.save(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages update(@RequestBody Messages message) {
        return messageService.update(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Long idMessage) {
        return messageService.deleteMessage(idMessage);
    }
}
