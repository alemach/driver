package ale.mach.driver.model.dtos;

import ale.mach.driver.model.Task;
import com.googlecode.jmapper.annotations.JGlobalMap;
import lombok.Data;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@JGlobalMap
public class TestDto {
	private int id;
	@NotBlank
	private String title;
	@NotEmpty
	@Size(min = 10, max = 10)
	private List<Task> tasks;
	@ManyToMany
	private List<ListElementTagDto> tags;
}
