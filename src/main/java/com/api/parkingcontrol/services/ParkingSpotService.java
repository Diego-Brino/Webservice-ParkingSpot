package com.api.parkingcontrol.services;

import com.api.parkingcontrol.exceptions.DuplicateLicensePlateCarException;
import com.api.parkingcontrol.exceptions.DuplicateParkingSpotByApartmentAndBlockException;
import com.api.parkingcontrol.exceptions.DuplicateParkingSpotNumberEception;
import com.api.parkingcontrol.exceptions.ParkingSpotNotFoundExecption;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        if (parkingSpotRepository.existsByLicensePlateCar(parkingSpotModel.getLicensePlateCar())) {
            throw new DuplicateLicensePlateCarException();
        }
        if (parkingSpotRepository.existsByParkingSpotNumber(parkingSpotModel.getParkingSpotNumber())) {
            throw new DuplicateParkingSpotNumberEception();
        }
        if (parkingSpotRepository.existsByApartmentAndBlock(parkingSpotModel.getApartment(), parkingSpotModel.getBlock())) {
            throw new DuplicateParkingSpotByApartmentAndBlockException();
        }
        parkingSpotRepository.save(parkingSpotModel);
        return parkingSpotModel;
    }

    public Optional<ParkingSpotModel> findById (UUID id) {
        if (parkingSpotRepository.findById(id).isEmpty()) {
            throw new ParkingSpotNotFoundExecption();
        }
        return parkingSpotRepository.findById(id);
    }

    public Page<ParkingSpotModel> findAll (Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }

    public List<ParkingSpotModel> findAll () {
        return parkingSpotRepository.findAll();
    }

    @Transactional
    public void delete (ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }
}
