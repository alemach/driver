package ale.mach.driver.controllers;

import ale.mach.driver.model.Tip;
import ale.mach.driver.model.dtos.TipDto;
import ale.mach.driver.service.TipService;
import com.googlecode.jmapper.JMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/tips")
@Validated
public class TipController {

	private final TipService service;
	private JMapper<TipDto, Tip> tipToDtoJMapper = new JMapper<TipDto, Tip>(TipDto.class, Tip.class);
	private JMapper<Tip, TipDto> dtoToTipJMapper = new JMapper<Tip, TipDto>(Tip.class, TipDto.class);

	public TipController(TipService service) {
		this.service = service;
	}

	@GetMapping("")
	public List<TipDto> findAll() {
		return service.findAll().stream().map(tipToDtoJMapper::getDestination).collect(Collectors.toCollection(ArrayList::new));
	}

	@GetMapping("/{id}")
	public TipDto findById(@PathVariable @Positive int id) {
		return tipToDtoJMapper.getDestination(service.findByID(id));
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public int create(@Valid @RequestBody TipDto tipDto) {
		return service.create(dtoToTipJMapper.getDestination(tipDto));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void update(@PathVariable @Positive int id, @Valid @RequestBody TipDto tipDto) {
		service.update(id, dtoToTipJMapper.getDestination(tipDto));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable @Positive int id) {
		service.delete(id);
	}
}
