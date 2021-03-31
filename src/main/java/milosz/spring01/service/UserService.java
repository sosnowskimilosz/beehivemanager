package milosz.spring01.service;

import milosz.spring01.model.User;
import milosz.spring01.repository.UserRepository;
import milosz.spring01.security.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer getIdOfUser(String userName){
        return userRepository.findIdOfUsername(userName);
    }

    public User getUserAccToUserName(String userName){
        return userRepository.findByUsername(userName);
    }

    public void addUser(User user){
        PasswordConfig encoder = new PasswordConfig();
        String encodedPassword = encoder.passwordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public boolean isUserNameExists(String userName){
        return userRepository.findByUsername(userName)==null ? false : true;
    }
}
