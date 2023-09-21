package spring.file.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.file.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
