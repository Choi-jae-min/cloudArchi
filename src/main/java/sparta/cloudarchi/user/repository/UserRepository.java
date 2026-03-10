package sparta.cloudarchi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.cloudarchi.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
