package ale.mach.driver.service;

import ale.mach.driver.model.Tag;

public interface TagService {

	Tag findByName(String name);
}
