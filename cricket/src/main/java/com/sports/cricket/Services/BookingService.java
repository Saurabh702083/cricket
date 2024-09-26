package com.sports.cricket.Services;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.sports.cricket.DTO.BookingDTO;
import com.sports.cricket.Entities.Booking;
import com.sports.cricket.Entities.Coach;
import com.sports.cricket.Repository.BookingRepository;
import com.sports.cricket.Repository.CoachRepository;
import com.sports.cricket.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CoachRepository coachRepository;

    public BookingService() {
    }

    public boolean bookAppointment(String userId, String coachId, BookingDTO bookingDTO) throws CustomException {
        LocalDate appointmentDate = bookingDTO.getAppointmentDate();
        String slot = bookingDTO.getSlot();
        List<Booking> bookingList = this.bookingRepository.findByUserId(userId);
        if (bookingList.stream().anyMatch((bookingx) -> {
            return bookingx.getAppointmentDate().equals(bookingDTO.getAppointmentDate()) && bookingx.getSlot().equals(bookingDTO.getSlot());
        })) {
            throw new CustomException(400, "BOOKING_ALREADY_EXISTS");
        } else {
            Booking booking = new Booking();
            booking.setUserId(userId);
            booking.setCoachId(coachId);
            booking.setAppointmentDate(appointmentDate);
            booking.setSlot(slot);
            this.bookingRepository.save(booking);
            Optional<Coach> optionalCoach = this.coachRepository.findById(coachId);
            if (optionalCoach.isPresent()) {
                Coach coach = (Coach)optionalCoach.get();
                coach.setNoOfBooking(coach.getNoOfBooking() + 1);
                this.coachRepository.save(coach);
                coach.setAmount(coach.getFees() * (double)coach.getNoOfBooking());
                this.coachRepository.save(coach);
            }

            return true;
        }
    }

    public Boolean rescheduleAppointment(Integer bookingId, BookingDTO bookingDTO) throws Exception {
        LocalDate newAppointmentDate = bookingDTO.getAppointmentDate();
        String newSlot = bookingDTO.getSlot();
        Optional<Booking> byId = this.bookingRepository.findById(bookingId);
        if (byId.isPresent()) {
            Booking booking = (Booking)byId.get();
            booking.setAppointmentDate(newAppointmentDate);
            booking.setSlot(newSlot);
            this.bookingRepository.save(booking);
            return true;
        } else {
            return false;
        }
    }

    public void cancelAppointment(Integer bookingId) throws CustomException {
        if (!this.bookingRepository.existsById(bookingId)) {
            throw new RuntimeException("User ID doesNot exist");
        } else {
            this.bookingRepository.deleteById(bookingId);
        }
    }
}
