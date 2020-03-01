package ale.mach.driver.model.dtos;

import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@JGlobalMap
public class TipDto {

	private int id;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	@NotEmpty
	@JMap("${ListElementTagDto}")
	private List<ListElementTagDto> tags;
}
