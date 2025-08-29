package com.example.notesapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoteRequestDTO {
    @NotBlank(message = "El título es obligatorio")
    private String title;
    private String content;
}