
package laboratory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import laboratory.entity.TestLab;

/**
 * @author daniel
 * @version 1.0 29/11/2022
 * contain the CRUD to tests table with JPA Spring 
 */
public interface TestsReporsitory extends JpaRepository<TestLab, Long> {

}
