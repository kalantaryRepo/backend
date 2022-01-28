package sp.spring.vue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.spring.vue.Entity.Expert;

public interface ExpertDao extends JpaRepository<Expert, Long> {
}
