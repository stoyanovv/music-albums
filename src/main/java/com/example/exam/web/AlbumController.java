package com.example.exam.web;

import com.example.exam.model.binding.AlbumAddBindingModel;
import com.example.exam.model.service.AlbumServiceModel;
import com.example.exam.model.service.UserServiceLoginModel;
import com.example.exam.service.AlbumService;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {

        private final AlbumService albumService;
        private final ModelMapper modelMapper;
        private final UserService userService;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper, UserService userService) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("albumAddBindingModel")) {
            model.addAttribute("albumAddBindingModel", new AlbumAddBindingModel());
        }
        return "add-album";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid AlbumAddBindingModel albumAddBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                              HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);
            return "redirect:add";
        }
        AlbumServiceModel albumServiceModel = albumService
                .findByAlbumName(albumAddBindingModel.getName());
        if (albumServiceModel != null) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            return "redirect:add";
        }
        redirectAttributes.addFlashAttribute("user",  httpSession.getAttribute("user"));
        UserServiceLoginModel userServiceLoginModel = modelMapper.map(httpSession.getAttribute("user"), UserServiceLoginModel.class);
        albumAddBindingModel.setAddedFrom(userService.findById(userServiceLoginModel.getId()));
        albumService.addAlbum(modelMapper.map(albumAddBindingModel, AlbumServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String buyById(@PathVariable String id, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        albumService.deleteAlbum(id);
        return "redirect:/";
    }
}
