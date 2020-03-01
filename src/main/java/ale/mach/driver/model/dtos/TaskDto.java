package ale.mach.driver.model.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;

@Data
public class TaskDto {

	private int id;
	@NotBlank
	private String question;
	@NotEmpty
	private HashSet<String> answers = new HashSet<>();
	@NotEmpty
	private List<ListElementTagDto> tags;
}
