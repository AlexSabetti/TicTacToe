package com.codingdojo.tictactoe.classes;

public class TTTMoveRequest {
	private Long gameId; //GameId will actually be in reference to matchId
	private Long userId;
	private int cell;
	
	public TTTMoveRequest() {
		
	}
	
	public TTTMoveRequest(Long gameId, Long userId, int cell) {
		this.gameId = gameId;
		this.userId = userId;
		this.cell = cell;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getCell() {
		return cell;
	}

	public void setCell(int cell) {
		this.cell = cell;
	}

	
	
	
}
