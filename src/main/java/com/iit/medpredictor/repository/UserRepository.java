package com.iit.medpredictor.repository;

import com.iit.medpredictor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository< User, Long >
{
	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

	Optional<User> findUserByUsernameAndAndPassword(String username, String password);
}
