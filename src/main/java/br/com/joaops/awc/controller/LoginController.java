/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author João
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    
    @RequestMapping
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/login/index");
        return mav;
    }
    
}