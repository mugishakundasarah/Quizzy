package com.quizzyapp.controller;

import com.quizzyapp.dto.RegistrationRequest;
import com.quizzyapp.service.UserService;
import com.quizzyapp.utils.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final EmailValidator emailValidator;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return userService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return userService.confirmToken(token);
    }
}
