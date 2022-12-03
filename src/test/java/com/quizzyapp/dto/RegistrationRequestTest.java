package com.quizzyapp.dto;

import com.quizzyapp.model.AccountType;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationRequestTest {

    RegistrationRequest request = new RegistrationRequest("kunda", "Mugisha", "sarah@gmail.com", "123", AccountType.TEACHER);
    @Test
    public void checkWhetherEmailIsSet(){
        assertEquals(request.getEmail(), "sarah@gmail.com");
    }
}