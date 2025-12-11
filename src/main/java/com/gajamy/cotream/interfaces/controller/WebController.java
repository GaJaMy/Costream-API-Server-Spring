package com.gajamy.cotream.interfaces.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("title", "ChzzkHub - 치지직 합방 플랫폼");
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "로그인 - ChzzkHub");
        return "login";
    }

    @GetMapping("/crew")
    public String crew(Model model) {
        model.addAttribute("title", "크루 관리 - ChzzkHub");
        return "crew";
    }

    @GetMapping("/friend")
    public String friend(Model model) {
        model.addAttribute("title", "친구 관리 - ChzzkHub");
        return "friend";
    }

    @GetMapping("/collaboration")
    public String collaboration(Model model) {
        model.addAttribute("title", "합방 관리 - ChzzkHub");
        return "collaboration";
    }
}
