package reto3.finca.entidades;

import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;


@Entity
@Table(name="fincas") 
public class Farms implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //idfarms
    @Column(name="name", nullable = false, length = 45)
    private String name;
    @Column(name="address", nullable = false, length = 45)
    private String address;
    @Column(name="extension")
    private Double extension;
    @Column(name="description", nullable = false, length = 250)
    private String description;

    // Relacion categoria-finca
    @ManyToOne
    @JoinColumn(name="CATEGORY")
    @JsonIgnoreProperties("farms") // category farms
    private Category category;

    // Relacion finca-mensajes
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="farm")
    @JsonIgnoreProperties({"farm","client"}) // client, farms
    private List<Messages> messages;

    // Relacion finca-reservas
    @OneToMany
    //@JsonIgnoreProperties({"farms","messages"})
    private List<Reservations> reservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getExtension() {
        return extension;
    }

    public void setExtension(Double extension) {
        this.extension = extension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }

    

    

    

    

    

    

    
}

    

    
    
    
    
    
    

