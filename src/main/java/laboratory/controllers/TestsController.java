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
import laboratory.entity.TestLab;
import laboratory.service.imple.TestsServiceImple;

/**
 * @author daniel
 * @version 1.0 29/11/2022
 * Controller that handles the flow of the Tests rest services.
 */
@RestController
@RequestMapping("/api/controller/test")
public class TestsController {

	@Autowired
	private TestsServiceImple testsServiceImple;

	@GetMapping(value = "listall")
	public ResponseEntity<?> testList() {
		List<TestLab> testFound = this.testsServiceImple.getList();
		if (testFound.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(testFound);
		}
	}

	@GetMapping(value = "getone/{id}")
	public ResponseEntity<?> objbyid(@PathVariable Long id) {
		try {
			TestLab elembyid = this.testsServiceImple.getById(id);
			if (elembyid == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(elembyid);
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(value = "add")
	public ResponseEntity<?> postTest(@RequestBody TestLab test) {
		try {
			TestLab affiliateSaved = this.testsServiceImple.post(test);
			return ResponseEntity.status(HttpStatus.CREATED).body(affiliateSaved);
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "update")
	public ResponseEntity<?> putTest(@RequestBody TestLab test) {

		Optional<TestLab> testUpdated = this.testsServiceImple.put(test);
		if (testUpdated.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(testUpdated);
		}

	}

	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<?> deleteTest(@PathVariable Long id) {
		try {
			this.testsServiceImple.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.noContent().build();
		}
	}

}