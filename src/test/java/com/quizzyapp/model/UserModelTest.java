package com.quizzyapp.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserModelTest {
    User user = new User("Ntaganda", "Patrick", "patrick@gmail.com", "123", AccountType.TEACHER);
    @Test
    public void checkConstructorSetsEmail(){
        assertEquals(user.getEmail(), "patrick@gmail.com");
    }
}