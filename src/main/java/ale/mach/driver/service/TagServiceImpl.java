package ale.mach.driver.service;

import ale.mach.driver.model.Tag;
import ale.mach.driver.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TagServiceImpl implements TagService {

	private final TagRepository tagRepository;

	public TagServiceImpl(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	@Override
	public Tag findByName(String name) {
		return tagRepository.findByName(name).orElseThrow(() -> new NoSuchElementException(String.format("No Tag object for name = %s", name)));
	}
}
