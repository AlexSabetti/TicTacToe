package com.codingdojo.tictactoe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.tictactoe.models.Game;
import com.codingdojo.tictactoe.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	GameRepository gameRepository;
	
	public List<Game> allGames(){
		return gameRepository.findAll();
	}
	
	public Game createGame(Game game) {
		return gameRepository.save(game);
	}
	
	public Game updateGame(Game game) {
		return gameRepository.save(game);
	}
	
	public void deleteGame(Long id) {
		gameRepository.deleteById(id);
	}
	
	public Game findGame(Long id) {
		Optional<Game> potentialGame = gameRepository.findById(id);
		if(potentialGame.isPresent()) {
			return potentialGame.get();
		} else {
			return null;
		}
	}
	
	/*public Game InstantiateTicTacToe() {
		
	}*/
}
