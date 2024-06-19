package com.codingdojo.tictactoe.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="matches")
public class Match {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//For the challengee
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="challengee_id")
	private User challengee;
	
	//For the creator of this match / the challenger
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="challenger_id")
	private User challenger;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="game_id")
	private Game game;
	
	private Integer turnCounter;
	
	private Boolean turn;
	
	private Integer info; 
	
	private Integer latestPost;
	
	

	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Match() {
		info = 222222222; //2's represent unused spaces, should be nine in total at the start 
	}
	
	public Match(User challenger, Game game, Integer info) {
		this.game = game;
		this.challenger = challenger;
		this.info = info;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getChallengee() {
		return challengee;
	}

	public void setChallengee(User challengee) {
		this.challengee = challengee;
	}

	public User getChallenger() {
		return challenger;
	}

	public void setChallenger(User challenger) {
		this.challenger = challenger;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}
	
	public Integer getLatestPost() {
		return latestPost;
	}

	public void setLatestPost(Integer latestPost) {
		this.latestPost = latestPost;
	}

	public Integer getTurnCounter() {
		return turnCounter;
	}

	public void setTurnCounter(Integer turnCounter) {
		this.turnCounter = turnCounter;
	}
	
	public void updateTurnCounter() {
		this.turnCounter += 1;
	}

	public Boolean getTurn() {
		return turn;
	}

	public void setTurn(Boolean turn) {
		this.turn = turn;
	}
	
	public void updateTurn(Boolean turn) {
		this.turn = !turn;
	}

	@PrePersist
	protected void onCreate()
	{
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		this.updatedAt = new Date();
	}
	
}
