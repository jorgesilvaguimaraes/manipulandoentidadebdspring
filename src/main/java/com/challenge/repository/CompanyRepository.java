package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

//    @Query(value = "select co.* from candidate c, company co where c.company_id = co.id and c.acceleration_id = :accelerationId ", nativeQuery = true)
    @Query(value = "SELECT DISTINCT c FROM Company c JOIN c.candidates ca where ca.id.acceleration.id = ?1")
    List<Company> findByAccelerationId(Long accelerationId);

//    @Query(value = "select co.* from candidate c, company co where c.company_id = co.id and c.user_id = :userId", nativeQuery = true)
    @Query(value = "SELECT DISTINCT c FROM Company c JOIN c.candidates ca where ca.id.user.id = ?1")
    List<Company> findByUserId(Long userId);
}
