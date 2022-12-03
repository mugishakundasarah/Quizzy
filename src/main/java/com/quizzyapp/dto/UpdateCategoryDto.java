package com.quizzyapp.dto;

import javax.validation.constraints.NotNull;

public class UpdateCategoryDto {
    private String name;

    public UpdateCategoryDto(@NotNull String name){
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
