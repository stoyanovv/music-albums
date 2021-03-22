package com.example.exam.web;

import com.example.exam.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

        private final AlbumService albumService;


    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }
        model.addAttribute("copies", albumService.getTotalCopies());
        model.addAttribute("albums", albumService.getAllAlbums());
        return "home";
    }

}
