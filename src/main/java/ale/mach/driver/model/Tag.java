package ale.mach.driver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String name;
	@ManyToMany(mappedBy = "tags")
	@JsonIgnore
	private List<Tip> tips;
	@ManyToMany(mappedBy = "tags")
	@JsonIgnore
	private List<Test> tests;
	@ManyToMany(mappedBy = "tags")
	@JsonIgnore
	private List<Task> tasks;

}
