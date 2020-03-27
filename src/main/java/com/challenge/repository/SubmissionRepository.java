package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    @Query(value = "select nvl2(max(s.score), max(s.score), 0) from submission s where s.challenge_id = ?1", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(Long challengeId);


    @Query(value = "select s.* from submission s, challenge c, acceleration a where s.challenge_id = c.id and c.id = a.challenge_id and s.challenge_id = :challengeId and a.id = :accelerationId", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,@Param("accelerationId") Long accelerationId);
}
