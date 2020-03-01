package ale.mach.driver.service.implementations;

import ale.mach.driver.model.Test;
import ale.mach.driver.repository.TestRepository;
import ale.mach.driver.service.TestService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TestServiceImpl implements TestService {

	private final TestRepository testRepository;

	public TestServiceImpl(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Override
	public void update(int id, Test test) {
		if (testRepository.findById(id).isPresent()) {
			testRepository.save(test);
		} else {
			throw new NoSuchElementException(String.format("No Test with id = %d", id));
		}
	}

	@Override
	public void delete(int id) {
		try {
			testRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchElementException(String.format("No Test with id = %d", id));
		}
	}

	@Override
	public int create(Test test) {
		return testRepository.save(test).getId();
	}


	@Override
	public Test findByID(int id) {
		return testRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("No Test with id = %d", id)));
	}


	@Override
	public List<Test> findAll() {
		return testRepository.findAll();
	}

}
