package ale.mach.driver.converters;

import ale.mach.driver.model.Tag;
import ale.mach.driver.service.TagService;
import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.stereotype.Component;

@Component
public class TagDtoConverter extends StdConverter<String, Tag> {

	private TagService service;

	public TagDtoConverter(TagService service) {
		this.service = service;
	}

	@Override
	public Tag convert(String name) {
		return service.findByName(name);
	}
}
