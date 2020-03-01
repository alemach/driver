package ale.mach.driver.service.implementations;

import ale.mach.driver.model.Tip;
import ale.mach.driver.repository.TipRepository;
import ale.mach.driver.service.TipService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TipServiceImpl implements TipService {

	private final TipRepository tipRepository;

	public TipServiceImpl(TipRepository tipRepository) {
		this.tipRepository = tipRepository;
	}

	@Override
	public void update(int id, Tip tip) {
		if (tipRepository.findById(id).isPresent()) {
			tipRepository.save(tip);
		} else {
			throw new NoSuchElementException(String.format("No Tip with id = %d", id));
		}
	}

	@Override
	public void delete(int id) {
		try {
			tipRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchElementException(String.format("No Tip with id = %d", id));
		}
	}

	@Override
	public int create(Tip tip) {
		return tipRepository.save(tip).getId();
	}

	@Override
	public Tip findByID(int id) {
		return tipRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("No Tip with id = %d", id)));
	}

	@Override
	public List<Tip> findAll() {
		return tipRepository.findAll();
	}
}
