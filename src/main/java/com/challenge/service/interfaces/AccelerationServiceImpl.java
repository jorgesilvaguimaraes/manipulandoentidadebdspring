package com.challenge.service.interfaces;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccelerationServiceImpl implements AccelerationServiceInterface {

    @Autowired
    AccelerationRepository accelerationRepository;


    @Override
    public Optional<Acceleration> findById(Long id) {
        return accelerationRepository.findById(id);
    }

    @Override
    public Acceleration findAccelerationByName(String name) {
        return accelerationRepository.findAccelerationByName(name);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return accelerationRepository.findByCompanyId(companyId);
    }

    @Override
    public Acceleration save(Acceleration object) {
        return accelerationRepository.save(object);
    }
}
