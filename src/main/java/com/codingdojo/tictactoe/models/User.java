package com.codingdojo.tictactoe.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Username is required!")
	@Size(min=3, max=30, message="Username must be between 3 and 30 characters!")
	private String userName;
	
	@NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    /*@Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;*/
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="creator", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Game> createdGames;
    
    @ManyToMany(fetch =FetchType.EAGER)
    @JoinTable(
    	name = "users_roles",
    	joinColumns = @JoinColumn(name = "user_id"),
    	inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
    
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Highscore> highscores;
    
    
    @OneToMany(mappedBy="challenger", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Match> challengerMatches;
    
    @OneToMany(mappedBy="challengee", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Match> challengeeMatches;
    
    private Integer wins;
    
    private Integer losses;
    
  
    public User() {}
    
    public User(String userName, String email, String password/*, String confirm*/) {
    	this.userName = userName;
    	this.email = email;
    	this.password = password; //Come back to this, probably
    	//this.confirm = confirm;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}*/

	
	public List<Match> getChallengerMatches() {
		return challengerMatches;
	}

	public void setChallengerMatches(List<Match> challengerMatches) {
		this.challengerMatches = challengerMatches;
	}

	public List<Match> getChallengeeMatches() {
		return challengeeMatches;
	}

	public void setChallengeeMatches(List<Match> challengeeMatches) {
		this.challengeeMatches = challengeeMatches;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) { 
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}
    
	public void updateWins() {
		this.wins += 1;
	}
	
	public void updateLosses() {
		this.losses += 1;
	}
	
	@PrePersist
	protected void onCreate()
	{
		this.createdAt = new Date();
		this.wins = 0;
		this.losses = 0;
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		this.updatedAt = new Date();
	}

	public List<Game> getCreatedGames() {
		return createdGames;
	}

	public void setCreatedGames(List<Game> createdGames) {
		this.createdGames = createdGames;
	}

	public List<Highscore> getHighscores() {
		return highscores;
	}

	public void setHighscores(List<Highscore> highscores) {
		this.highscores = highscores;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
    
	
}

