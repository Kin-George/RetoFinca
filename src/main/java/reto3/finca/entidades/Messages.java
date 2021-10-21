package reto3.finca.entidades;

import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mensajes")
public class Messages implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;
    @Column(name = "messageText", nullable = false, length = 250)
    private String messageText;

    // Relacion mensaje-finca
    @ManyToOne
    @JsonIgnoreProperties({ "messages", "reservations" })
    private Farms farm;

    // Relacion mensaje-cliente
    @ManyToOne
    @JsonIgnoreProperties({ "messages", "reservations" })
    private Client client;

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Farms getFarm() {
        return farm;
    }

    public void setFarm(Farms farm) {
        this.farm = farm;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
