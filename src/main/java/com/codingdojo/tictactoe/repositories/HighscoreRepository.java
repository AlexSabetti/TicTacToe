package com.codingdojo.tictactoe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.tictactoe.models.Highscore;

@Repository
public interface HighscoreRepository extends CrudRepository<Highscore, Long>{
	Optional<Highscore> findByGameIdAndUserId(Long gameid, Long userId);
	List<Highscore> findAllByUserId(Long id);
	List<Highscore> findAllByGameId(Long id);
}
