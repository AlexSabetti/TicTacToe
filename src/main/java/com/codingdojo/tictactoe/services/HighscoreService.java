package com.codingdojo.tictactoe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.tictactoe.models.Highscore;
import com.codingdojo.tictactoe.repositories.HighscoreRepository;

@Service
public class HighscoreService {
	@Autowired
	private HighscoreRepository highscoreRepository;
	
	public Highscore updateHighscore(Highscore highscore) {
		Optional<Highscore> potentialHighscore = highscoreRepository.findByGameIdAndUserId(highscore.getGame().getId(), highscore.getUser().getId());
		if(potentialHighscore.isPresent()) {
			Highscore originalHighscore = potentialHighscore.get();
			if (originalHighscore.getScore() < highscore.getScore()) {
				return highscoreRepository.save(highscore);
			} else {
				return highscore;
			}
		} else {
			return null;
		}
	}
	
	public Highscore findByGameAndUser(Long gameId, Long userId) {
		Optional<Highscore> potentialHighscore = highscoreRepository.findByGameIdAndUserId(gameId, userId);
		if (potentialHighscore.isPresent()) {
			return potentialHighscore.get();
		} else {
			return null;
		}
	}
	
	public List<Highscore> findAllByUser(Long id){
		return highscoreRepository.findAllByUserId(id);
	}
	
	public List<Highscore> findAllByGame(Long id){
		return highscoreRepository.findAllByGameId(id);
	}
}
