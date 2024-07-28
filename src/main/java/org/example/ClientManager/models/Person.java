package org.example.ClientManager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Person")
public class Person{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Name should not be empty")
	@Size(min=2, max=30, message="Name should be between 2 and 30 characters")
	@Column(name = "name")
	private String name;

	@Min(value = 1, message ="Age should be greater than 0")
	@Column(name = "age")
	private int age;

	@Column(name = "email")
	@NotEmpty(message = "Email sould not be empty")
	@Email
	private String email;

	@OneToMany(mappedBy = "owner")
	private List<Item> items;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy") //convert String from form to date format
	private Date dateOfBirth;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	public Person(){

	}
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Person(int id, String name, int age) {
		this.name = name;
		this.age = age;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return id == person.id && age == person.age && Objects.equals(name, person.name) && Objects.equals(email, person.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, age, email);
	}
}
