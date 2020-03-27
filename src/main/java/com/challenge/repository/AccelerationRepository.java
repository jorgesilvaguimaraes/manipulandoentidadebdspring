package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    Acceleration findAccelerationByName(String name);

//    @Query(value = "select a.* from Candidate c where c.acceleration_id = a.id and c.company_id = :companyId ", nativeQuery = true)
    @Query(value = "SELECT a FROM Acceleration a JOIN a.candidates c where c.id.company.id = ?1")
    List<Acceleration> findByCompanyId(Long companyId);

}
