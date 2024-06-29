package com.codingdojo.tictactoe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.tictactoe.models.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long>{
	Optional<Game> findByName(String name);
	List<Game> findAll();
}
