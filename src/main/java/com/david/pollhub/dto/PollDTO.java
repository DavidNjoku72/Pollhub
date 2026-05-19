package com.david.pollhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PollDTO {

    @NotBlank(message = "Question cannot be empty")
    @Size(min = 5, max = 255, message = "Question must be between 5 and 255 characters")
    private String question;

    @NotBlank(message = "Creator name cannot be empty")
    private String createdBy;

    public PollDTO() {
    }

    public PollDTO(String question, String createdBy) {
        this.question = question;
        this.createdBy = createdBy;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}