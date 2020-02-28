package ale.mach.driver.repository;

import ale.mach.driver.model.Tip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipRepository extends JpaRepository<Tip, Integer> {
}
