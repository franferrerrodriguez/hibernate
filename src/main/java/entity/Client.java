package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "clients")
@Table(name = "clients")
public class Client {

	@Id
	// For AUTO_INCREMENT id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "firstname")
	public String firstname;

	@Column(name = "lastname")
	public String lastname;

	@Column(name = "nifnie")
	public String nifnie;

	@Column(name = "email")
	public String email;

	@Column(name = "country")
	public String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNifnie() {
		return nifnie;
	}

	public void setNifnie(String nifnie) {
		this.nifnie = nifnie;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
