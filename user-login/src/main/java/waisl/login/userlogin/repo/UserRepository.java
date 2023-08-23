package waisl.login.userlogin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import waisl.login.userlogin.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}