package sp.spring.vue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sp.spring.vue.Entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
