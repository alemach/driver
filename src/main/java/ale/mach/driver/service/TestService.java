package ale.mach.driver.service;

import ale.mach.driver.model.Test;

import java.util.List;

public interface TestService {

	void update(int id, Test test);

	void delete(int id);

	int create(Test test);

	Test findByID(int id);

	List<Test> findAll();
}
