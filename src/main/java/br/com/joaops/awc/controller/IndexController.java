/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.controller;

import br.com.joaops.awc.dto.SystemModuleDto;
import br.com.joaops.awc.dto.SystemUserFormDto;
import br.com.joaops.awc.dto.SystemUserPermissionDto;
import br.com.joaops.awc.dto.SystemUserPermissionIdDto;
import br.com.joaops.awc.model.SystemUserPermission;
import br.com.joaops.awc.service.SystemModuleService;
import br.com.joaops.awc.service.SystemUserService;
import java.util.ArrayList;
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
    
    @Autowired
    private SystemModuleService systemModuleService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    
}