package com.codegym.controller;

import com.codegym.model.Phone;
import com.codegym.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


@Controller
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/phones")
    public ModelAndView listPhones(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Phone> phones;
        if (s.isPresent()) {
            phones = phoneService.findAllByNameContaining(s.get(), pageable);
        } else {
            phones = phoneService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("phones", phones);
        return modelAndView;
    }
//    @GetMapping("/phones")
//    public ModelAndView listPhones(Pageable pageable){
//        Page<Phone> phones = phoneService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("/phone/list");
//        modelAndView.addObject("phones",phones);
//        return modelAndView;
//    }

    //    @GetMapping("/phones")
//    public ModelAndView listPhone(){
//        Iterable<Phone> phones = phoneService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/phone/list");
//        modelAndView.addObject("phones",phones);
//        return modelAndView;
//    }
    @GetMapping("/create-phone")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/phone/create");
        modelAndView.addObject("phone", new Phone());
        return modelAndView;
    }

    @PostMapping("/create-phone")
    public ModelAndView savePhone(@ModelAttribute("phone") Phone phone) {
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("/phone/create");
        modelAndView.addObject("phone", new Phone());
        modelAndView.addObject("message", "New phone create successfully!");
        return modelAndView;
    }

    @GetMapping("/edit-phone/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Phone phone = phoneService.findById(id);
        if (phone != null) {
            ModelAndView modelAndView = new ModelAndView("/phone/edit");
            modelAndView.addObject("phone", phone);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-phone")
    public ModelAndView updatePhone(@ModelAttribute("phone") Phone phone) {
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("/phone/edit");
        modelAndView.addObject("phone", phone);
        modelAndView.addObject("message", "phone updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-phone/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Phone phone = phoneService.findById(id);
        if (phone != null) {
            ModelAndView modelAndView = new ModelAndView("/phone/delete");
            modelAndView.addObject("phone", phone);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-phone")
    public String deletePhone(@ModelAttribute("phone") Phone phone) {
        phoneService.remove(phone.getId());
        return "redirect:phones";
    }
}
