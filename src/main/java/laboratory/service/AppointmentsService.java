/**
 * 
 */
package laboratory.service;


import java.util.List;
import java.util.Optional;

import laboratory.entity.Affiliate;
import laboratory.entity.Appointment;


/**
 * @author daniel
 * @version 1.0 29/11/2022
 * interface that contain the methods for Appoinments 
 */
public interface AppointmentsService {

	/**
	 * method that allows queries the list of appoinments
	 * 
	 * @return appoinments List
	 */
	List<Appointment> getList();

	/**
	 * method that allows queries the list of appointments
	 * 
	 * @param appointment {@link int} appointment object to get
	 * @return appointment object
	 */
	Appointment getById(Long id);

	/**
	 * method that allows queries the list of appointments of one affiliate
	 * 
	 * @param affiliate {@link Affiliate} appointment object to get
	 * @return appointment object
	 */
	List<Appointment> getByAffiliate(Affiliate affiliate);

	/**
	 * method that allows queries the list of appointments of one affiliate
	 * 
	 * @param date {@link Appointment} appointment object to get
	 * @return appointment object
	 */
	List<Appointment> getByDate(String date);

	/**
	 * method that save the appoinment
	 * 
	 * @param appointment {@link Appointment} appointment object to save
	 * @return appointment saved
	 */
	Appointment post(Appointment appoinment);

	/**
	 * method that update the appoinment object
	 * 
	 * @param appoinment {@link Appointment} appoinment object to update
	 * @return appoinment updated
	 */
	Optional<Appointment> put(Appointment appoinment);

	/**
	 * method that delete one appoinment's item from the database
	 * 
	 * @param appoinment {@link int} appoinment object to delete
	 * @return test deleted
	 */
	void delete(Long id);

}
