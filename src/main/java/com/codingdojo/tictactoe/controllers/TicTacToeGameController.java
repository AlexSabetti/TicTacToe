package com.codingdojo.tictactoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.tictactoe.classes.TTTMoveRequest;
import com.codingdojo.tictactoe.classes.TicTacToeGameboard;
import com.codingdojo.tictactoe.models.Match;
import com.codingdojo.tictactoe.models.User;
import com.codingdojo.tictactoe.services.MatchService;
import com.codingdojo.tictactoe.services.UserService;

@RestController
public class TicTacToeGameController {
	@Autowired
	MatchService matchService;
	@Autowired
	UserService userService;
	
	@PostMapping("/api/move")
	public ResponseEntity<Integer[]> handleMove(@RequestBody TTTMoveRequest moveRequest){
		Match match = matchService.findMatch(moveRequest.getGameId());
		User player_A = match.getChallengee();
		User player_B = match.getChallenger();
		TicTacToeGameboard board = new TicTacToeGameboard(match.getInfo());
		int cellCondition = 0;
		if(player_B.getId() == moveRequest.getUserId()) {
			cellCondition = 1;
		} else {
			cellCondition = 2;
		}
		
		board.setCell(moveRequest.getCell(), cellCondition);
		int condition = board.checkGameCondition();
		if(condition == 0) {
			if(moveRequest.getUserId() == player_B.getId()) {
				userService.updateUserWins(player_B.getId());
				userService.updateUserLosses(player_A.getId());
				//player_B.updateWins();
				//player_A.updateLosses();
			} else {
				//player_A.updateLosses();
				userService.updateUserLosses(player_B.getId());
				//player_B.updateWins();
				userService.updateUserWins(player_A.getId());
			}
			
			matchService.deleteMatch(moveRequest.getGameId());
			
		} else if(condition == 1) {
			if (moveRequest.getUserId() == player_B.getId()) {
				match.setTurn(player_A.getId());
			} else {
				match.setTurn(player_B.getId());
			} 
			
			match.setInfo(board.convertToNotation());
			match.updateTurnCounter();
			matchService.updateMatch(match);
		} else {
			//We've hit a draw, no score updates
			matchService.deleteMatch(moveRequest.getGameId());
		}
		Integer[] payload = new Integer[]{condition, cellCondition};
		return ResponseEntity.ok(payload);
	}
	
	@GetMapping("/api/get/{gameId}")
	public ResponseEntity<int[]> requestState(@PathVariable("gameId") Long gameId){
		Match match = matchService.findMatch(gameId);
		TicTacToeGameboard board = new TicTacToeGameboard(match.getInfo());
		return ResponseEntity.ok(board.getSimpleCol());
	}
	
	@GetMapping("/api/{gameId}/exit")
	public String requestLeave(@PathVariable("gameId") Long gameId) {
		return "redirect:/games/" + gameId + "/home";
	}
	
	@GetMapping("/api/{matchId}/refresh")
	public String requestRefresh(@PathVariable("matchId") Long matchId) {
		Match match = matchService.findMatch(matchId);
		return "redirect:/games/" + match.getGame().getId() + "/home/matches/" + match.getId();
	}
}
