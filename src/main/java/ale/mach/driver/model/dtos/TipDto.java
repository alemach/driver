package ale.mach.driver.model.dtos;

import ale.mach.driver.model.Tag;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class TipDto {

	private int id;
	@NotNull
	@NotBlank
	private String title;
	@NotNull
	@NotBlank
	private String content;
	@NotNull
	@NotEmpty
	private List<Tag> tags;
}
