package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ParkingSpotService {

    //    final ParkingSpotRepository parkingSpotRepository; //Mesma coisa que o autowired.
    //
    //    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    //        this.parkingSpotRepository = parkingSpotRepository;
    //    }

    @Autowired //Criar uma injeção, em momentos especifícos.
    ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public ParkingSpotModel save (ParkingSpotModel parkingSpotModel) {

        parkingSpotRepository.save(parkingSpotModel);
        return parkingSpotModel;
    }
}
