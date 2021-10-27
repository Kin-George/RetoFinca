package reto3.finca.entidades;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(name = "clientes") 
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "age", nullable = false, length = 45)
    private Integer age;

    // Relacion cliente-mensaje
    @OneToMany
    private List<Messages> messages;

    // Relacion cliente-reservas
    @OneToMany
    private List<Reservations> reservations;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
