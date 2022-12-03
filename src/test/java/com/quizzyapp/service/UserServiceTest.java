package com.quizzyapp.service;

import com.quizzyapp.model.AccountType;
import com.quizzyapp.model.User;
import com.quizzyapp.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    User user = new User("Ntaganda", "Patrick", "patrick@gmail.com", "123", AccountType.TEACHER);
    @InjectMocks
    UserService userService;

}

