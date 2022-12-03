/**
 * 
 */
package laboratory.service.imple;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import laboratory.entity.Affiliate;
import laboratory.entity.Appointment;
import laboratory.repository.AppointmentsRepository;
import laboratory.service.AppointmentsService;
import org.springframework.stereotype.Service;


/**
 * @author daniel
 * @version 1.0 29/11/2022
 * Class to implements the methods from AppoinmentsService interface 
 */
@Service
public class AppointmentsServiceImpl implements AppointmentsService {

	/**
	 * methods implementation to run the CRUD
	 */

	@Autowired
	private AppointmentsRepository appointmentsRepository;

	@Override
	public List<Appointment> getlist() {
		// due to return a iterable is necessary use this code
		List<Appointment> listAll = StreamSupport.stream(this.appointmentsRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());

		return listAll;
	}

	@Override
	public Appointment getbyid(Long id) {
		return this.appointmentsRepository.findById(id).get();
	}

	@Override
	public List<Appointment> getbyaffiliate(Affiliate affiliate) {
		List<Appointment> appointments = this.appointmentsRepository.findByIdAffiliateOrderByDateAsc(affiliate);
		return appointments;
	}

	@Override
	public Appointment post(Appointment appointment) {
		return this.appointmentsRepository.save(appointment);
	}

	@Override

	public Optional<Appointment> put(Appointment appointment) {
		Optional<Appointment> objSet = appointmentsRepository.findById(appointment.getId());
		if (objSet.isPresent()) {
			Appointment objToUpdate = objSet.get();
			objToUpdate.setDate(appointment.getDate());
			objToUpdate.setHour(appointment.getHour());
			objToUpdate.setIdTest(appointment.getIdTest());
			objToUpdate.setIdAffiliate(appointment.getIdAffiliate());
			appointmentsRepository.save(objToUpdate);
			return Optional.ofNullable(objToUpdate);
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void delete(Long id) {
		this.appointmentsRepository.deleteById(id);
	}

	@Override
	public List<Appointment> getbyDate(String date) {
		LocalDate value = LocalDate.parse(date);
		List<Appointment> appointments = this.appointmentsRepository.findByDateOrderByIdAffiliateAsc(value);
		return appointments;
	}

}
