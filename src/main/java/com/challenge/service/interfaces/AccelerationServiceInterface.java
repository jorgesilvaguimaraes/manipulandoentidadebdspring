package com.challenge.service.interfaces;

import com.challenge.entity.Acceleration;

import java.util.List;
import java.util.Optional;

public interface AccelerationServiceInterface extends ServiceInterface<Acceleration> {

    Optional<Acceleration> findById(Long id);

    Acceleration findAccelerationByName(String name);

    List<Acceleration> findByCompanyId(Long companyId);

}
