package ale.mach.driver.controllers;

import ale.mach.driver.model.Tip;
import ale.mach.driver.service.TipService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tips")
public class TipController {

	private final TipService service;

	public TipController(TipService service) {
		this.service = service;
	}

	@GetMapping("")
	public List<Tip> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Tip findById(@PathVariable int id) {
		return service.findByID(id);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public int create(@RequestBody Tip tip) {
		return service.create(tip);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void update(@PathVariable int id, @RequestBody Tip tip) {
		service.update(id, tip);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id){
		service.delete(id);
	}
}
