package sp.spring.vue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sp.spring.vue.Entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
}
