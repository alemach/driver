package ale.mach.driver.service;

import ale.mach.driver.model.Tip;

import java.util.List;

public interface TipService {

	void update(int id, Tip tip);

	void delete(int id);

	int create(Tip tip);

	Tip findByID(int id);

	List<Tip> findAll();
}
