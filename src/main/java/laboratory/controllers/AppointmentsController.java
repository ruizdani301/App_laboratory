/**
 * 
 */
package laboratory.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import laboratory.entity.Affiliate;
import laboratory.entity.Appointment;
import laboratory.service.AppointmentsService;

/**
 * @author daniel
 * @version 1.0 29/11/2022 COntroller that handles the flow of the Appoinments
 *          rest services.
 */

@RestController
@RequestMapping("/api/controller/appointments")
public class AppointmentsController {

	@Autowired
	private AppointmentsService appointmentsServiceImpl;

	@GetMapping(value = "listall")
	public ResponseEntity<?> appointmentsList() {
		List<Appointment> appoinmentsFound = this.appointmentsServiceImpl.getList();
		if (appoinmentsFound.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(appoinmentsFound);
		}
	}

	@GetMapping(value = "getone/{id}")
	public ResponseEntity<?> objById(@PathVariable Long id) {
		try {
			Appointment elembyid = this.appointmentsServiceImpl.getById(id);
			if (elembyid == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(elembyid);
			}
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping(value = "add")
	public ResponseEntity<?> postAppo(@RequestBody Appointment appointment) {
		try {
			Appointment appointmentSaved = this.appointmentsServiceImpl.post(appointment);
			return ResponseEntity.status(HttpStatus.CREATED).body(appointmentSaved);
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "update")
	public ResponseEntity<?> putAppo(@RequestBody Appointment appointment) {
		Optional<Appointment> appoUpdated = this.appointmentsServiceImpl.put(appointment);
		if (appoUpdated.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(appoUpdated);
		}
	}

	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<?> deleteAppo(@PathVariable Long id) {
		try {
			this.appointmentsServiceImpl.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping(value = "affiliates/{idAffiliate}")
	public ResponseEntity<?> listAffiliates(@PathVariable Affiliate idAffiliate) {
		List<Appointment> affiliateFound = this.appointmentsServiceImpl.getByAffiliate(idAffiliate);
		if (affiliateFound.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(affiliateFound);
		}
	}

	@GetMapping(value = "group/{date}")
	public ResponseEntity<?> listGroup(@PathVariable String date) {
		List<Appointment> groupFound = this.appointmentsServiceImpl.getByDate(date);
		if (groupFound.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(groupFound);
		}
	}
}
