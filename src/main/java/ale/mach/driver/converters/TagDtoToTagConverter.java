package ale.mach.driver.converters;

import ale.mach.driver.model.Tag;
import ale.mach.driver.model.dtos.ListElementTagDto;
import ale.mach.driver.service.TagService;
import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.stereotype.Component;

@Component
public class TagDtoToTagConverter extends StdConverter<ListElementTagDto, Tag> {

	private TagService service;

	public TagDtoToTagConverter(TagService service) {
		this.service = service;
	}

	@Override
	public Tag convert(ListElementTagDto listElementTagDto) {
		return service.findByName(listElementTagDto.getName());
	}
}
