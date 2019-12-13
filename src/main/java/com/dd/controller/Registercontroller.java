package com.dd.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dd.entity.User;
import com.dd.service.SecurityService;
import com.dd.service.UserService;

public class Registercontroller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/register")
    public String register(Model model) {

        model.addAttribute("userForm", new User());

        return "register";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
    
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userService.save(userForm);

        return "redirect:/data";
    }


}
