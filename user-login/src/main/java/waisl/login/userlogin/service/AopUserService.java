package waisl.login.userlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waisl.login.userlogin.model.AopUser;
import waisl.login.userlogin.repo.AopUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AopUserService {

    private final AopUserRepository userRepository;

    @Autowired
    public AopUserService(AopUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AopUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<AopUser> getUserById(String id) {
        return userRepository.findById(id);
    }

    public AopUser createUser(AopUser user) {
        return userRepository.save(user);
    }

    public AopUser updateUser(String id, AopUser user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null; // Handle case when user doesn't exist
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
