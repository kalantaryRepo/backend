package sp.spring.vue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sp.spring.vue.Entity.Customer;
import sp.spring.vue.Entity.Expert;
import sp.spring.vue.Entity.User;
import sp.spring.vue.dao.CustomerDao;
import sp.spring.vue.dao.ExpertDao;
import sp.spring.vue.dao.UserDao;
import sp.spring.vue.dto.UserDto;
import sp.spring.vue.enums.UserType;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ExpertDao expertDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto saveUser(UserDto userDto) {
        User saved = new User();
        if (UserType.CUSTOMER.getName().equals(userDto.getUserType())) {
            Customer cu = convertUserDto2Customer(userDto);
            cu.setPassword(passwordEncoder.encode(cu.getPassword()));
            Customer customer = customerDao.save(cu);
            return convertUser2UserDto(customer);
        } else if (UserType.EXPERT.getName().equals(userDto.getUserType())) {
            Expert ex = convertUserDto2Expert(userDto);
            ex.setPassword(passwordEncoder.encode(ex.getPassword()));
            Expert expert = expertDao.save(ex);
            return convertUser2UserDto(expert);
        }
        return new UserDto();
    }

    private Customer convertUserDto2Customer(UserDto userDto) {
        //todo lombok,builder
        Customer user = new Customer();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRegistrationDate(new Date());
        return user;
    }

    private Expert convertUserDto2Expert(UserDto userDto) {
        //todo lombok,builder
        Expert user = new Expert();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRegistrationDate(new Date());
        return user;
    }

    private UserDto convertUser2UserDto(User user) {
        return new UserDto(user.getId().toString(), user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = new User();
        userEntity.setEmail(username);
        Optional<User> found = userDao.findOne(Example.of(userEntity));
        if (!found.isPresent())
            throw new UsernameNotFoundException("[" + username + "] not found");

        User user = found.get();
        Set<GrantedAuthority> authorities = new HashSet<>();
//        for (RoleEntity role : user.getRoles()) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), authorities);
    }
}
