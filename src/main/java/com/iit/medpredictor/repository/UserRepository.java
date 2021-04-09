package com.iit.medpredictor.repository;

import com.iit.medpredictor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository< User, Long >
{
	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

	Optional<User> findUserByUsernameAndAndPassword(String username, String password);

	User findUserByUsername(String username);

	@Query(value = "select count(u) from User u")
	Long countAll();

}
