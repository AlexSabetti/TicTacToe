package com.codingdojo.tictactoe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.tictactoe.models.Role;
import com.codingdojo.tictactoe.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
	Optional<User> findByEmail(String email);
	List<User> findByRoles(List<Role> list);
	
	@Modifying
	@Query(value="UPDATE users SET wins = ?1 WHERE id = ?2", nativeQuery = true)
	void updateWins(Integer num, Long id);
	
	@Modifying
	@Query(value="UPDATE users SET losses = ?1 WHERE id = ?2", nativeQuery = true)
	void updateLosses(Integer num, Long id);
	
	@Query(value="SELECT * FROM users ORDER BY wins DESC", nativeQuery=true)
	List<User> getAllUsersSortedByScore();
}
