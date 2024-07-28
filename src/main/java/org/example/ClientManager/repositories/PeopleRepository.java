package org.example.ClientManager.repositories;

import org.example.ClientManager.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person,Integer> {
	List<Person> findByName(String name);

	List<Person> findByNameOrderByAge(String name);

	List<Person> findByEmail(String email);

	List<Person> findByNameStartingWith(String startWith);

	List<Person> findByNameOrEmail(String name, String email);

}