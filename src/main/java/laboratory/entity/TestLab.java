/**
 * 
 */
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
 * This class represents Test entities
 */
@Entity
@Table(name = "test")
public class TestLab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_test")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	/**
	 * 
	 */
	public TestLab() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public TestLab(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
