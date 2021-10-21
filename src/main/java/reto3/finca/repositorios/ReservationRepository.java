package reto3.finca.repositorios;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto3.finca.entidades.Reservations;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservations> getAll() {
        return (List<Reservations>) reservationCrudRepository.findAll();
    }

    public Optional<Reservations> getReservation(Long idReservation) {
        return reservationCrudRepository.findById(idReservation);
    }

    public Reservations save(Reservations r) {
        return reservationCrudRepository.save(r);
    }

}
