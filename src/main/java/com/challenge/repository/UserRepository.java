package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

//    @Query(value = "select u.* from candidate c, user u, acceleration a where c.user_id = u.id and c.acceleration_id = a.id and a.name = :name ", nativeQuery = true)
    @Query(value = "SELECT u FROM User u JOIN u.candidates c where c.id.acceleration.name = ?1")
    List<User> findByAccelerationName(String name);

//    @Query(value = "select u.* from candidate c, user u, company co where c.user_id = u.id and c.company_id = co.id and co.id = :id", nativeQuery = true)
    @Query(value = "SELECT u FROM User u JOIN u.candidates c where c.id.company.id = ?1")
    List<User> findByCompanyId(Long companyId);

}
