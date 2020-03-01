package ale.mach.driver.controllers;

import ale.mach.driver.model.Test;
import ale.mach.driver.model.dtos.TestDto;
import ale.mach.driver.service.TestService;
import com.googlecode.jmapper.JMapper;
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

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/driver/test")
public class TestController {

	private final TestService service;
	private JMapper<TestDto, Test> testToDtoJMapper = new JMapper<TestDto, Test>(TestDto.class, Test.class);
	private JMapper<Test, TestDto> dtoToTestJMapper = new JMapper<Test, TestDto>(Test.class, TestDto.class);

	public TestController(TestService service) {
		this.service = service;
	}

	@GetMapping("")
	public List<TestDto> findAll() {
		return service.findAll().stream().map(testToDtoJMapper::getDestination).collect(Collectors.toCollection(ArrayList::new));
	}

	@GetMapping("/{id}")
	public TestDto findById(@PathVariable @Positive int id) {
		return testToDtoJMapper.getDestination(service.findByID(id));
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public int create(@Valid @RequestBody TestDto testDto) {
		return service.create(dtoToTestJMapper.getDestination(testDto));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void update(@PathVariable @Positive int id, @Valid @RequestBody TestDto testDto) {
		service.update(id, dtoToTestJMapper.getDestination(testDto));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable @Positive int id) {
		service.delete(id);
	}
}
