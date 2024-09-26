package com.sports.cricket.Repository;

//import com.WeCare.WeCare.Entities.Coach;
import com.sports.cricket.Entities.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, String> {
}
