package laboratory.entity;

import java.time.*;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author daniel
 * @version 1.0 29/11/2022
 * This class represents appointments entities
 */
// Data:  allow to create implicit getters and setters

@Entity
@Table(name = "appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "date")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "hour")
	@JsonFormat(pattern = "HH:mm")
	private LocalTime hour;

	@JoinColumn(name = "id_test")
	@Basic(fetch = FetchType.EAGER)
	@ManyToOne(cascade = {CascadeType.MERGE})
	private TestLab idTest;

	@JoinColumn(name = "id_affiliate")
	@Basic(fetch = FetchType.EAGER)
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Affiliate idAffiliate;

	public Appointment() {

	}

	/**
	 * @param id
	 * @param date
	 * @param hour
	 * @param idTest
	 * @param idAffiliate Constructor Appointment class
	 */
	public Appointment(Long id, LocalDate date, LocalTime hour, TestLab idTest, Affiliate idAffiliate) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.idTest = idTest;
		this.idAffiliate = idAffiliate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public TestLab getIdTest() {
		return idTest;
	}

	public void setIdTest(TestLab idTest) {
		this.idTest = idTest;
	}

	public Affiliate getIdAffiliate() {
		return idAffiliate;
	}

	public void setIdAffiliate(Affiliate idAffiliate) {
		this.idAffiliate = idAffiliate;
	}

}
