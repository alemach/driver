package ale.mach.driver.converters;

import ale.mach.driver.model.Tag;
import ale.mach.driver.service.TagService;
import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TagConverter extends StdConverter<String, Tag> {

//	@Autowired
	private TagService service;

	public TagConverter(TagService service) {
		this.service = service;
	}

	@Override
	public Tag convert(String name) {
		return service.findByName(name);
	}
}
