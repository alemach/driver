package ale.mach.driver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue
	private int id;
	@NotBlank
	private String question;
	@NotBlank
	private String correctAnswer;
	@NotBlank
	private String incorrectAnswer0;
	@NotBlank
	private String incorrectAnswer1;
	@NotBlank
	private String incorrectAnswer2;
	@ManyToMany
	@NotEmpty
	private List<Tag> tags;
}
