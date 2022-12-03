/**
 * 
 */
package laboratory.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import laboratory.entity.Affiliate;
import laboratory.entity.Appointment;

/**
 * @author daniel
 * @version 1.0 29/11/2022
 * contain the CRUD to appoinments table with JPA Spring 
 */
//public interface AppoinmentsRepository extends JpaRepository<Appoinments, Number> {

//}
public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {
	List<Appointment> findByIdAffiliateOrderByDateAsc(Affiliate affiliate);
	
	List<Appointment> findByDateOrderByIdAffiliateAsc(LocalDate date);
}