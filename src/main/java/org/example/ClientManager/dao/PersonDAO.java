package org.example.ClientManager.dao;


import jakarta.persistence.EntityManager;
import org.example.ClientManager.models.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Set;

@Component
public class PersonDAO {
	private EntityManager entityManager;

	public PersonDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional(readOnly = true)
	public void testNPlus1(){
		Session session = entityManager.unwrap(Session.class);
	//Problem N+1
		//1 query
//		List<Person> people = session.createQuery("select p from Person p", Person.class).getResultList();
		//N query
//		for(Person p: people){
//			System.out.println("person: "+ p.getName()+" has: "+p.getItems());
//		}

	//Solution
		Set<Person> people = new HashSet<Person>(session.createQuery("select p from Person p LEFT JOIN FETCH p.items", Person.class).getResultList());

		for(Person p: people){
			System.out.println("person: "+ p.getName()+" has: "+p.getItems());
		}
	}

}
