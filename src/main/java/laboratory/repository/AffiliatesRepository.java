package laboratory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import laboratory.entity.Affiliate;

/**
 * @author daniel
 * @version 1.0 29/11/2022
 * contain the CRUD to affiliates table with JPA Spring 
 */
public interface AffiliatesRepository extends JpaRepository<Affiliate, Long>{
	
}
