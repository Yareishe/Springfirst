package com.example.mes.notelist.repo;

import com.example.mes.notelist.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {

}
