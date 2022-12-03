/**
 * 
 */
package laboratory.service;

import java.util.List;
import java.util.Optional;

import laboratory.entity.Affiliate;


/**
 * @author daniel
 * @version 1.0 29/11/2022
 * interface that contain the methods for Affiliates  
 */
public interface AffiliatesService {

	/**
	 * method that allows queries the list of tests
	 * 
	 * @return affiliates List
	 */
	List<Affiliate> getlist();

	/**
	 * method that allows queries the list of tests
	 * 
	 * @param affiliate {@link int} affiliate object to get
	 * @return affiliate object
	 */
	Affiliate getbyid(Long id);

	/**
	 * method that save the affiliate
	 * 
	 * @param affiliate {@link Affiliates} affiliate object to save
	 * @return affiliate saved
	 */
	Affiliate post(Affiliate affiliate);

	/**
	 * method that update the tests object
	 * 
	 * @param affiliate {@link Affiliates} affiliate object to update
	 * @return test updated
	 */
	Optional<Affiliate> put(Affiliate affiliate);

	/**
	 * method that delete one item from the database
	 * 
	 * @param affiliate {@link int} affiliate object to delete
	 * @return test deleted
	 */
	void delete(Long id);

}
