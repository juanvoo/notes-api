package com.example.notesapi.controller;

import com.example.notesapi.dto.NoteDTO;
import com.example.notesapi.dto.NoteRequestDTO;
import com.example.notesapi.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@Tag(name = "Notas", description = "API para gestión de notas personales")
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    @Operation(summary = "Obtener todas las notas")
    public ResponseEntity<List<NoteDTO>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una nota por ID")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    @PostMapping
    @Operation(summary = "Crear una nueva nota")
    public ResponseEntity<NoteDTO> createNote(@Valid @RequestBody NoteRequestDTO dto) {
        return ResponseEntity.ok(noteService.createNote(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una nota existente")
    public ResponseEntity<NoteDTO> updateNote(@PathVariable Long id, @Valid @RequestBody NoteRequestDTO dto) {
        return ResponseEntity.ok(noteService.updateNote(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una nota por ID")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}