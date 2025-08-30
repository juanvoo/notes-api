package com.example.notesapi.service;

import com.example.notesapi.dto.NoteDTO;
import com.example.notesapi.entity.Note;
import org.springframework.stereotype.Component;
import com.example.notesapi.dto.NoteRequestDTO;

@Component
public class NoteMapper {
    public NoteDTO toDTO(Note note){
        NoteDTO dto = new NoteDTO();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        dto.setCreatedAt(note.getCreatedAt());
        dto.setUpdatedAt(note.getUpdatedAt());
        return dto;
    }

    public Note toEntity(NoteRequestDTO dto){
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        return note;
    }
}

