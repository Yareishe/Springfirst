package com.example.Springfirst.CRUD;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class NoteServicelmpl implements NoteService {


    private Map<Long, Note> notesMap = new HashMap<>();
    private Long avtoid = 1L;


    @Override
    public List<Note> listAll() {
        return new ArrayList<>(notesMap.values()) ;
    }
    @Override
    public Note add(Note note) {
        note.setId(avtoid);
        notesMap.put(avtoid,note);
        avtoid++;
        return note;
    }

    @Override
    public void deleteById(long id) {
        notesMap.remove(id);
    }

    @Override
    public void update(Note note) {
        notesMap.put(note.getId(),note);
    }

    @Override
    public Note getById(long id) {
        return notesMap.get(id);
    }
}