package ale.mach.driver.model.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class ListElementTagDto {

	@Positive
	private int id;
	@NotBlank
	private String name;
}
