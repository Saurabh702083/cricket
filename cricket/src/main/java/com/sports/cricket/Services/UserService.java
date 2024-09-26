package com.sports.cricket.Services;

//package com.WeCare.WeCare.Services;

//import com.WeCare.WeCare.DTO.UserDTO;
//import com.WeCare.WeCare.Entities.User;
//import com.WeCare.WeCare.Repository.UserRepository;
//import com.WeCare.WeCare.exception.CustomException;
import java.util.Optional;
import java.util.UUID;

import com.sports.cricket.DTO.UserDTO;
import com.sports.cricket.Entities.User;
import com.sports.cricket.Repository.UserRepository;
import com.sports.cricket.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService() {
    }

    public String createUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString().substring(0, 5));
        user.setName(userDTO.getName());
        user.setGender(userDTO.getGender());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setPincode(userDTO.getPincode());
        user.setCity(userDTO.getCity());
        user.setState(userDTO.getState());
        user.setCountry(userDTO.getCountry());
        this.userRepository.save(user);
        return "Registered the user details successfully";
    }

    public Boolean loginUser(String userId, String password) throws Exception {
        Optional<User> byId = this.userRepository.findById(userId);
        if (byId.isEmpty()) {
            throw new CustomException(400, "USER_NOT_FOUND" + userId);
        } else {
            return ((User)byId.get()).getPassword().equals(password);
        }
    }

    public UserDTO getUser(String userId) throws Exception {
        User user = (User)this.userRepository.findById(userId).orElseThrow(() -> {
            return new CustomException(400, "User not found with id: " + userId);
        });
        return this.convertToDTO(user);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setGender(user.getGender());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setMobileNumber(user.getMobileNumber());
        userDTO.setPincode(user.getPincode());
        userDTO.setCity(user.getCity());
        userDTO.setState(user.getState());
        userDTO.setCountry(user.getCountry());
        return userDTO;
    }
}

