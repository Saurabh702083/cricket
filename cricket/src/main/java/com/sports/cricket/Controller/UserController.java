package com.sports.cricket.Controller;
//import com.WeCare.WeCare.DTO.UserDTO;
//import com.WeCare.WeCare.Services.UserService;
import com.sports.cricket.DTO.UserDTO;
import com.sports.cricket.Services.UserService;
import jakarta.validation.Valid;
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
@RequestMapping({"/users"})
public class UserController {
    @Autowired
    UserService userService;

    public UserController() {
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO userDTO) {
        String response = this.userService.createUser(userDTO);
        return new ResponseEntity(response, HttpStatusCode.valueOf(200));
    }

    @GetMapping({"/login"})
    public ResponseEntity<Boolean> login(@RequestParam("userId") String userId, @RequestParam("password") String password) throws Exception {
        boolean result = this.userService.loginUser(userId, password);
        return new ResponseEntity(result, HttpStatusCode.valueOf(200));
    }

    @GetMapping({"/{userId}"})
    public ResponseEntity<UserDTO> getByUserId(@PathVariable String userId) throws Exception {
        UserDTO userDTO = this.userService.getUser(userId);
        return new ResponseEntity(userDTO, HttpStatusCode.valueOf(200));
    }
}
