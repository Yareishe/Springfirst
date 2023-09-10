package com.example.mes.controlers.Controler;

import com.example.mes.controlers.serves.NoteServicelmpl;
import com.example.mes.controlers.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller()
@RequestMapping("/note")
@Slf4j
public class MassageControler {


    private NoteServicelmpl noteServicelmpl;

    public MassageControler(NoteServicelmpl noteServicelmpl) {
        this.noteServicelmpl = noteServicelmpl;
    }


    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteServicelmpl.listAll());
        return "list";
    }



    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
    public String deleteNotes(@RequestParam Long id) {
        noteServicelmpl.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/add")
    public String addgetNotes(@ModelAttribute("note") Note note, Model model) {
        return "add";
    }

    @PostMapping("/add")
    public String addpostNotes(@ModelAttribute("note") Note note, Model model) {
        noteServicelmpl.update(note);

        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editeNotes(@RequestParam("id") Long id, Model model) {
        Note newNote = noteServicelmpl.getById(id);
        model.addAttribute("note", newNote);

        return "edit";
    }

    @PostMapping("/edit")
    public String editNotes(@ModelAttribute("note") Note note, Model model) {

        Note newNote = noteServicelmpl.getById(note.getId());
        newNote.setTitle(note.getTitle());
        newNote.setContent(note.getContent());
        noteServicelmpl.update(newNote);

        model.addAttribute("note", newNote);
        return "redirect:/note/list";
    }




}