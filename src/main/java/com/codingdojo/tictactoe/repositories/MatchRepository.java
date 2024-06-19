package com.codingdojo.tictactoe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.tictactoe.models.Match;
import com.codingdojo.tictactoe.models.User;

@Repository
public interface MatchRepository extends CrudRepository <Match, Long>{
	List<Match> findAll();
	Optional<User> findByChallengerId(Long id);
	Optional<User> findByChallengeeId(Long id);
	
	@Query(value="SELECT * FROM matches WHERE challengee = NULL", nativeQuery=true)
	List<Match> findAllUnfilledMatches();
	
	List<Match> findAllByGameId(Long id);
}
