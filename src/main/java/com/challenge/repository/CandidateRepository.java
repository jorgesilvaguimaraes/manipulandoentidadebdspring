package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends CrudRepository<Candidate,CandidateId> {

//    @Query(value = " select c.* from Candidate c where c.user_id = :userId and c.company_id = :companyId and c.acceleration_id = :accelerationId", nativeQuery = true)
    @Query(value = "SELECT c FROM Candidate c where c.id.user.id= ?1 and c.id.company.id = ?2 and c.id.acceleration.id = ?3")
    Optional<Candidate> findById(Long userId, Long companyId,Long accelerationId);

//    @Query(value="select c.* from candidate c where c.company_id = :companyId", nativeQuery = true)
    @Query(value = "SELECT c FROM Candidate c where c.id.company.id = :companyId")
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

//    @Query(value="select c.* from candidate c where c.acceleration_id = :accelerationId", nativeQuery = true)
    @Query(value = "SELECT c FROM Candidate c where c.id.acceleration.id = :accelerationId")
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);
}
