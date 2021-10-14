package reto3.finca.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import reto3.finca.entidades.Reservations;
import reto3.finca.repositorios.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservations> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservations> getReservation(Long idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    public Reservations save(Reservations r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional <Reservations> raux=reservationRepository.getReservation(r.getIdReservation());
            if(raux.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }
}
