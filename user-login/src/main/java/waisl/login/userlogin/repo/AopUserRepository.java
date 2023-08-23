package waisl.login.userlogin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import waisl.login.userlogin.model.AopUser;

public interface AopUserRepository extends JpaRepository<AopUser, String> {
    // You can add custom query methods here if needed
}
