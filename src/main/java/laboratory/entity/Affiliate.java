
package laboratory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author daniel
 * @version 1.0 29/11/2022
 * This class represents affiliates entities
 */
// Data:  allow to create implicit getters and setters

@Entity
@Table(name = "affiliates")
public class Affiliate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_affiliate")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "email", unique = true)
	private String email;

	public Affiliate() {

	}

	/**
	 * @param name
	 * @param age
	 * @param email Affiliates class constructor
	 */
	public Affiliate(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
