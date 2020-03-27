package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

//    @Query(value = "select c from challenge c, submission s, acceleration a where c.id = s.challenge_id and c.id = a.challenge_id and a.id = :accelerationId and s.user_id = :userId", nativeQuery = true)
    @Query(value = "SELECT c from Challenge c JOIN c.submissions s JOIN c.accelerations a where a.id = ?1 and s.id.user.id = ?2")
    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);
}
