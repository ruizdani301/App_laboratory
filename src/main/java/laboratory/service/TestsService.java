/**
 * 
 */
package laboratory.service;
import java.util.List;
import java.util.Optional;

import laboratory.entity.TestLab;

/**
 * @author daniel
 * @version 1.0 29/11/2022
 * interface that contain the methods for Tests  
 */

public interface TestsService {

	/**
	 * method that allows queries the list of tests
	 * 
	 * @return tests List
	 */
	List<TestLab> getList();

	/**
	 * method that allows queries the list of tests
	 * 
	 * @param test {@link int} test object to get
	 * @return tests object
	 */
	TestLab getById(Long id);

	/**
	 * method that save the tests
	 * 
	 * @param test {@link TestLab} test object to save
	 * @return test saved
	 */
	TestLab post(TestLab test);

	/**
	 * method that update the tests object
	 * 
	 * @param test {@link Tests} test object to update
	 * @return test updated
	 */
	// Optional<TestLab> put(TestLab test);
	Optional<TestLab> put(TestLab test);

	/**
	 * method that delete one item from the database
	 * 
	 * @param test {@link int} test object to delete
	 * @return test deleted
	 */
	 void delete(Long id);
		
}
