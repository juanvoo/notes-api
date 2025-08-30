package com.example.notesapi.service;

import com.example.notesapi.dto.NoteDTO;
import com.example.notesapi.dto.NoteRequestDTO;
import com.example.notesapi.entity.Note;
import com.example.notesapi.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public List<NoteDTO> getAllNotes() {
        return noteRepository.findAll().stream()
                .map(noteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public NoteDTO getNoteById(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada con ID: " + id));
        return noteMapper.toDTO(note);
    }

    public NoteDTO createNote(NoteRequestDTO dto) {
        Note note = noteMapper.toEntity(dto);
        Note saved = noteRepository.save(note);
        return noteMapper.toDTO(saved);
    }

    public NoteDTO updateNote(Long id, NoteRequestDTO dto) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada con ID: " + id));
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        Note updated = noteRepository.save(note);
        return noteMapper.toDTO(updated);
    }

    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada con ID: " + id));
        noteRepository.delete(note);
    }
}