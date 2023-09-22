package com.example.mes.notelist.controler;

import com.example.mes.notelist.entity.User;
import com.example.mes.notelist.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/")
public class RegistrationControler {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationControler(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String getRegistration(User user, Model model){
        model.addAttribute("user", user);
        return "registration";
    }
    @PostMapping("/registration")
    public String successRegistration(@ModelAttribute("user")User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
