/**
 * 
 */
package laboratory.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laboratory.entity.Affiliate;
import laboratory.service.AffiliatesService;

/**
 * @author daniel
 * @version 1.0 29/11/2022
 * Controller that handles the flow of the Affilliate rest services.
 */

@RestController
@RequestMapping("/api/controller/affiliates")
public class AffiliatesController {

	@Autowired
	private AffiliatesService affiliatesServiceImple;

	@GetMapping(value = "listall")
	public ResponseEntity<?> affiliatesList() {
		List<Affiliate> affiliatesFound = this.affiliatesServiceImple.getList();
		if (affiliatesFound.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(affiliatesFound);
		}
	}

	@GetMapping(value = "getone/{id}")
	public ResponseEntity<?> objbyid(@PathVariable Long id) {
		try {
			Affiliate elembyid = this.affiliatesServiceImple.getById(id);
			if (elembyid == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(elembyid);
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(value = "add")
	public ResponseEntity<?> postAffiliate(@RequestBody Affiliate affiliate) {
		try {
			Affiliate affiliateSaved = this.affiliatesServiceImple.post(affiliate);
			return ResponseEntity.status(HttpStatus.CREATED).body(affiliateSaved);
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "update")

	public ResponseEntity<?> putAffiliate(@RequestBody Affiliate affiliate) {

		Optional<Affiliate> testUpdated = this.affiliatesServiceImple.put(affiliate);
		if (testUpdated.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(testUpdated);
		}
	}

	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<?> deleteAffiliate(@PathVariable Long id) {
		try {
			this.affiliatesServiceImple.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.noContent().build();
		}
	}

}
