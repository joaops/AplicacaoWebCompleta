/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.controller;

import br.com.joaops.awc.dto.SystemUserFormDto;
import br.com.joaops.awc.service.SystemUserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author João Paulo
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    
    @Autowired
    private SystemUserService systemUserService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("redirect:/");
        SystemUserFormDto user = new SystemUserFormDto();
        user.setFirstName("João");
        user.setMiddleName("Paulo");
        user.setLastName("Siqueira");
        user.setEmail("joaopaulo1094@gmail.com");
        user.setConfirmEmail("joaopaulo1094@gmail.com");
        user.setPassword("admin");
        user.setConfirmPassword("admin");
        systemUserService.save(user);
        return mav;
    }
    
    
}