package com.sports.cricket.Controller;

import com.sports.cricket.DTO.CoachDTO;
import com.sports.cricket.Entities.Coach;
import com.sports.cricket.Services.CoachService;
import com.sports.cricket.exception.CustomException;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/coaches"})
public class CoachController {
    @Autowired
    CoachService coachService;

    public CoachController() {
    }

    @PostMapping({"/create"})
    public ResponseEntity<String> createCoach(@RequestBody @Valid CoachDTO coachDTO) {
        String response = this.coachService.createCoach(coachDTO);
        return new ResponseEntity(response, HttpStatusCode.valueOf(200));
    }

    @GetMapping({"/login"})
    public ResponseEntity<Boolean> login(@RequestParam("coachId") String coachId, @RequestParam("password") String password) throws Exception {
        boolean result = this.coachService.login(coachId, password);
        return ResponseEntity.ok(result);
    }

    @GetMapping({"/{coachId}"})
    public ResponseEntity<CoachDTO> getCoachById(@PathVariable String coachId) throws CustomException {
        CoachDTO coachDTO = this.coachService.getCoachById(coachId);
        return new ResponseEntity(coachDTO, HttpStatusCode.valueOf(200));
    }

    @GetMapping({"/all"})
    public List<CoachDTO> getAllCoachDetail() {
        List<CoachDTO> allCoach = this.coachService.getAllCoach();
        return allCoach;
    }

    @GetMapping({"allCoachesGreater/{noOfBooking}"})
    public List<Coach> getCoach(@PathVariable("noOfBooking") Integer noOfBooking) {
        List<Coach> coachList = this.coachService.getChoaches(noOfBooking);
        return coachList;
    }
}

