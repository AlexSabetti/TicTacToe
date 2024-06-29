package com.codingdojo.tictactoe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.tictactoe.models.Match;
import com.codingdojo.tictactoe.repositories.MatchRepository;

@Service
public class MatchService {
	@Autowired   
	MatchRepository matchRepository;
	
	public List<Match> allMatches(){
		return matchRepository.findAll();
	}
	
	public Match findMatch(Long id) {
		Optional<Match> potentialMatch = matchRepository.findById(id);
		if(potentialMatch.isPresent()) {
			return potentialMatch.get();
		}else {
			return null;
		}
	}
	
	public Match createMatch(Match match) {
		return matchRepository.save(match);
	}
	
	public Match updateMatch(Match match) {
		return matchRepository.save(match);
	}
	
	public void deleteMatch(Long id) {
		matchRepository.deleteById(id);
	}
	
	/*public Match progressTurn(Match match) {
		match.updateTurnCounter();
		boolean didWin = checkMatchStatus(match);
		if(didWin == true) {
			if(match.getTurn()) {
				//Challenger wins if the turn is set to 0
				match.getChallenger().updateWins();
				match.getChallengee().updateLosses();
			} else {
				match.getChallengee().updateWins();
				match.getChallenger().updateLosses();
			}
			
			deleteMatch(match.getId());
			return null;
		} else {
			match.updateTurn(match.getTurn());
			return match;
		}
		
	}
	
	public Boolean checkMatchStatus(Match match) {
		boolean matchDecided = false;
		Integer gameInfo = match.getInfo();
		int[] boardPlacement = new int[9];
		for(int i = 8; i >= 0; i--) {
			boardPlacement[i] = gameInfo % 10;
			gameInfo /= 10;
		}
		//Long way of doing it, unoptimized
		if(boardPlacement[0] != 2) {
			
			if(boardPlacement[0] == boardPlacement[1] && boardPlacement[2] == boardPlacement[0]) {
				//A 3 in a row has occurred. Because we would have caught this last turn, this must be new, and the current player wins. <-- Quite lazy and probably will cause issues
				matchDecided = true;
			} else if(boardPlacement[0] == boardPlacement[3] && boardPlacement[6] == boardPlacement[0]) {
				//Same thing here
				matchDecided = true;
			} else if(boardPlacement[0] == boardPlacement[4] && boardPlacement[8] == boardPlacement[0]) {
				//Same thing here
				matchDecided = true;
			}
		}
		
		if(boardPlacement[1] != 2 && matchDecided == false) {
			if(boardPlacement[1] == boardPlacement[4] && boardPlacement[7] == boardPlacement[1]) {
				//A 3 in a row has occurred. Because we would have caught this last turn, this must be new, and the current player wins. <-- Quite lazy and probably will cause issues
				matchDecided = true;
			}
		}
		
		if(boardPlacement[3] != 2 && matchDecided == false) {
			if(boardPlacement[3] == boardPlacement[4] && boardPlacement[5] == boardPlacement[3]) {
				//A 3 in a row has occurred. Because we would have caught this last turn, this must be new, and the current player wins. <-- Quite lazy and probably will cause issues
				matchDecided = true;
			}
		}
		
		if(boardPlacement[6] != 2 && matchDecided == false) {
			if(boardPlacement[6] == boardPlacement[4] && boardPlacement[2] == boardPlacement[6]) {
				matchDecided = true;
				
			} else if(boardPlacement[6] == boardPlacement[7] && boardPlacement[8] == boardPlacement[6]) {
				matchDecided = true;
				
			}
		}
		
		if(boardPlacement[8] != 2 && matchDecided == false) {
			if(boardPlacement[8] == boardPlacement[5] && boardPlacement[2] == boardPlacement[8]) {
				matchDecided = true;
			}
		}
		
		return matchDecided;
	}*/
	
	public List<Match> allUnfilledMatches(){
		return matchRepository.findAllUnfilledMatches();
	}
	
	public List<Match> allGameSpecificMatches(Long id){
		return matchRepository.findAllByGameId(id);
	}
	
	
}
