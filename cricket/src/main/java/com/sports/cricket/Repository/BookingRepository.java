package com.sports.cricket.Repository;

//import com.WeCare.WeCare.Entities.Booking;
import java.util.List;

import com.sports.cricket.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByCoachId(String coachId);

    List<Booking> findByUserId(String userId);
}
