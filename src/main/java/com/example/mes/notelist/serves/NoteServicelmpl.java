package com.example.mes.notelist.serves;


import com.example.mes.notelist.entity.Note;
import com.example.mes.notelist.repo.NoteRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;



@Service
@Data
@RequiredArgsConstructor
public class NoteServicelmpl implements NoteService {

    private final NoteRepository noteRepository;

    public Map<Long, Note> notesMap = new HashMap<>();
    public Long avtoid = 1L;


    @Override
    public List<Note> listAll() {

        return new ArrayList<>(noteRepository.findAll()) ;
    }
    @Override
    public Note add(Note note) {

        notesMap.put(note.getId(),note);
        return noteRepository.save(note);
    }

    @Override
    public void deleteById(long id) {
        noteRepository.deleteById(id);

    }

    @Override
    public void update(Note note) {
        noteRepository.save(note);
    }

    @Override
    public Optional<Note> getById(long id) {
        return noteRepository.findById(id);
    }
}