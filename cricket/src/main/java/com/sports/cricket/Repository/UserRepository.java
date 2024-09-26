package com.sports.cricket.Repository;

//import com.WeCare.WeCare.Entities.User;
import com.sports.cricket.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
