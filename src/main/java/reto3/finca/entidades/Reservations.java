package reto3.finca.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="reservas")
public class Reservations implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(name="startDate", nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name="devolutionDate", nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    private Date devolutionDate;

    private String status="created";

    // Relacion reservas-finca
    @ManyToOne
    @JoinColumn(name="farm_id")
    @JsonIgnoreProperties("reservations")
    private Farms farm;

    // Relacion reservas-cliente
    @ManyToOne
    //@JoinColumn(name="idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;

    // Relacion score-reservas
    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy="reservations")
    @JsonIgnoreProperties("reservations")
    private Score score;

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    


    

    

    
    
    

    



    
    

    
    
}
