package laboratory.service.imple;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import laboratory.entity.Affiliate;
import laboratory.repository.AffiliatesRepository;
import laboratory.service.AffiliatesService;

/**
* @author daniel
* @version 1.0 29/11/2022
* Class to implements the methods from TestsService interface 
*/
@Service
public class AffiliatesServiceImple implements AffiliatesService {
	/**
	 * methods implementation to run the CRUD
	 */

	@Autowired
	private AffiliatesRepository affiliatesRepository;

	@Override
	public List<Affiliate> getList() {
		return StreamSupport.stream(this.affiliatesRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());

	}

	@Override
	public Affiliate getById(Long id) {
		return this.affiliatesRepository.findById(id).get();
	}

	@Override
	public Affiliate post(Affiliate affiliate) {
		return this.affiliatesRepository.save(affiliate);
	}

	@Override
	public Optional<Affiliate> put(Affiliate affiliate) {
		Optional<Affiliate> objSet = affiliatesRepository.findById(affiliate.getId());
		if (objSet.isPresent()) {
			Affiliate objToUpdate = objSet.get();
			objToUpdate.setName(affiliate.getName());
			objToUpdate.setAge(affiliate.getAge());
			objToUpdate.setEmail(affiliate.getEmail());
			affiliatesRepository.save(objToUpdate);
			return Optional.ofNullable(objToUpdate);
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void delete(Long id) {
		this.affiliatesRepository.deleteById(id);

	}
}
