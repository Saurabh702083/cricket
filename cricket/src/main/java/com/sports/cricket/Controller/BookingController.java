package com.sports.cricket.Controller;

import com.sports.cricket.DTO.BookingDTO;
import com.sports.cricket.Services.BookingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping
public class BookingController {
    @Autowired
    BookingService bookingService;

    public BookingController() {
    }

    @PostMapping({"/users/{userId}/booking/{coachId}"})
    public ResponseEntity<Boolean> bookAppointment(@PathVariable String userId, @PathVariable String coachId, @RequestBody BookingDTO bookingDTO) throws Exception {
        Boolean result = this.bookingService.bookAppointment(userId, coachId, bookingDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping({"/booking/{bookingId}"})
    public ResponseEntity<Boolean> rescheduleAppointment(@PathVariable Integer bookingId, @RequestBody BookingDTO bookingDTO) throws Exception {
        Boolean result = this.bookingService.rescheduleAppointment(bookingId, bookingDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping({"/booking/{bookingId}"})
    public ResponseEntity<?> CancelAppointment(@PathVariable Integer bookingId) throws Exception {
        this.bookingService.cancelAppointment(bookingId);
        return ResponseEntity.ok().build();
    }
}
