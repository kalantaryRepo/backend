package sp.spring.vue.Entity;

import sp.spring.vue.enums.UserStatus;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sp_Customer")
public class Customer extends User {

//    public Customer(String firstName, String lastName, String email, String password, UserStatus userStatus, Date registrationDate) {
//        this.setFirstName(firstName);
//        this.setLastName(lastName);
//        this.setEmail(email);
//        this.setPassword(password);
//        this.setUserStatus(userStatus);
//        this.setRegistrationDate(registrationDate);
//    }

}
