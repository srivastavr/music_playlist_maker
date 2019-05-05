package net.guides.springboot2.springboot2jpacrudexample.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.model.Songs;
import net.guides.springboot2.springboot2jpacrudexample.model.playlistmodel;

@Repository
public interface playlistrepo extends JpaRepository<playlistmodel, Long>{

	@Query(value = "SELECT * FROM playlist_data u WHERE u.user_id = ?1 ", nativeQuery = true)
	List<playlistmodel> findById(String username);
	}
