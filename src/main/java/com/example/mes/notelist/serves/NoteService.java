package com.example.mes.notelist.serves;


import com.example.mes.notelist.entity.Note;

import java.util.List;
import java.util.Optional;


public interface NoteService {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Optional<Note> getById(long id);
}