package com.example.mes.controlers.Controler;

import com.example.mes.controlers.serves.NoteServicelmpl;
import com.example.mes.controlers.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller()
@RequestMapping("/note")
@Slf4j
public class MassageControler {

    List<String> messagar = new ArrayList<>();


    private Map<Long, Note> notes = new HashMap<>();
    private long nextId = 1;


    private NoteServicelmpl noteServicelmpl;

    public MassageControler(NoteServicelmpl noteServicelmpl) {
        this.noteServicelmpl = noteServicelmpl;
    }


    @GetMapping("/list")
    public String listNotes(Model model) {
        Note note = new  Note(1L,"i","g");
        noteServicelmpl.add(note);
        model.addAttribute("notes", noteServicelmpl.listAll());
        System.out.println("ffff");
        return "list";
    }


    @PostMapping("/list")
    public String saveNotes(@RequestParam(name = "id") Long id,
                            @RequestParam(name = "title") String title,
                            @RequestParam(name = "content") String content ,
                            Model model) {
        Note note = new  Note(id,title,content);
        noteServicelmpl.add(note);
        System.out.println(note);
        model.addAttribute("notes",noteServicelmpl.listAll());
        return "list";
    }
    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
    public String deleteNotes(@RequestParam Long id) {
        noteServicelmpl.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editeNotes() {
        return "edit";
    }

    @PostMapping("/edit")
    public String editNotes(@ModelAttribute("note") Note note, Model model) {

        noteServicelmpl.add(note);
        System.out.println(note);
        return "redirect:/note/list";
    }




}
