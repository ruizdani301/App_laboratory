/**
 * 
 */
package laboratory.service.imple;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import laboratory.entity.TestLab;
import laboratory.repository.TestsReporsitory;
import laboratory.service.TestsService;

/**
 * @author daniel
 * @version 1.0 29/11/2022
 * Class to implements the methods from TestsService interface 
 */

@Service
public class TestsServiceImple implements TestsService {
	/**
	 * methods implementation to run the CRUD
	 */

	@Autowired
	private TestsReporsitory testRepository;

	@Override
	public List<TestLab> getList() {
		return StreamSupport.stream(this.testRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public TestLab getById(Long id) {
		return this.testRepository.findById(id).get();
	}

	@Override
	public TestLab post(TestLab test) {
		return this.testRepository.save(test);
	}

	@Override
	public Optional<TestLab> put(TestLab test) {
		Optional<TestLab> objSet = testRepository.findById(test.getId());
		if (objSet.isPresent()) {
			TestLab objToUpdate = objSet.get();
			objToUpdate.setName(test.getName());
			objToUpdate.setDescription(test.getDescription());
			testRepository.save(objToUpdate);
			return Optional.ofNullable(objToUpdate);
		} else {
			return Optional.empty();
		}
	}

	
	 @Override 
	 public void delete(Long id) {
	   this.testRepository.deleteById(id);
	  
	 }
		
}

