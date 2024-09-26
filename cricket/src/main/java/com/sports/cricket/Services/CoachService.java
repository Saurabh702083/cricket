package com.sports.cricket.Services;



import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.sports.cricket.DTO.CoachDTO;
import com.sports.cricket.Entities.Coach;
import com.sports.cricket.Repository.CoachRepository;
import com.sports.cricket.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {
    @Autowired
    CoachRepository coachRepository;

    public CoachService() {
    }

    public String createCoach(CoachDTO coachDTO) {
        Coach coach = new Coach();
        coach.setCoachId(UUID.randomUUID().toString().substring(0, 5));
        coach.setName(coachDTO.getName());
        coach.setGender(coachDTO.getGender());
        coach.setDateOfBirth(coachDTO.getDateOfBirth());
        coach.setSpeciality(coachDTO.getSpeciality());
        coach.setMobileNumber(coachDTO.getMobileNumber());
        coach.setPassword(coachDTO.getPassword());
        coach.setFees(coachDTO.getFees());
        this.coachRepository.save(coach);
        return "Registered the coach details successfully";
    }

    public boolean login(String coachId, String password) throws CustomException {
        Optional<Coach> byId = this.coachRepository.findById(coachId);
        if (byId.isEmpty()) {
            throw new CustomException(400, "COACH_NOT_FOUND");
        } else {
            return ((Coach)byId.get()).getPassword().equals(password);
        }
    }

    public CoachDTO getCoachById(String coachId) throws CustomException {
        Coach coach = (Coach)this.coachRepository.findById(coachId).orElseThrow(() -> {
            return new CustomException(400, "Coach not found with id: " + coachId);
        });
        return this.convertToDTO(coach);
    }

    private CoachDTO convertToDTO(Coach coach) {
        CoachDTO coachDTO = new CoachDTO();
        coachDTO.setName(coach.getName());
        coachDTO.setGender(coach.getGender());
        coachDTO.setDateOfBirth(coach.getDateOfBirth());
        coachDTO.setPassword(coach.getPassword());
        coachDTO.setMobileNumber(coach.getMobileNumber());
        coachDTO.setSpeciality(coach.getSpeciality());
        return coachDTO;
    }

    public List getAllCoach() {
        List<Coach> listOfCoach = this.coachRepository.findAll();
        return (List)listOfCoach.stream().map(this::concertTOCoachDTO).collect(Collectors.toList());
    }

    private CoachDTO concertTOCoachDTO(Coach coach) {
        CoachDTO coachsDTO = new CoachDTO();
        coachsDTO.setName(coach.getName());
        coachsDTO.setGender(coach.getGender());
        coachsDTO.setDateOfBirth(coach.getDateOfBirth());
        coachsDTO.setSpeciality(coach.getSpeciality());
        coachsDTO.setMobileNumber(coach.getMobileNumber());
        return coachsDTO;
    }

    public List<Coach> getChoaches(Integer noOfBooking) {
        List<Coach> listOfCoaches = this.coachRepository.findAll();
        Iterator var3 = listOfCoaches.iterator();

        while(var3.hasNext()) {
            Coach coach = (Coach)var3.next();
            if (coach.getNoOfBooking() < noOfBooking) {
                listOfCoaches.remove(coach);
            }
        }

        return listOfCoaches;
    }
}

