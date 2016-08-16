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
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("redirect:/");
        try {
            SystemUserFormDto user = new SystemUserFormDto();
            user.setFirstName("João");
            user.setMiddleName("Paulo");
            user.setLastName("Siqueira");
            user.setEmail("joaopaulo1094@gmail.com");
            user.setConfirmEmail("joaopaulo1094@gmail.com");
            user.setPassword("admin");
            user.setConfirmPassword("admin");
            systemUserService.save(user);
        } catch (Exception e) {
            System.err.println("[ERRO_SYSTEM_USER]: "+e);
        }
        try {
            SystemModuleDto moduleDto = new SystemModuleDto();
            moduleDto.setId(1L);
            moduleDto.setName("SYSTEM");
            moduleDto.setCategory("USER");
            moduleDto.setSystemUserPermission(new ArrayList<>());
            systemModuleService.save(moduleDto);
        } catch (Exception e) {
            System.err.println("[ERRO_SYSTEM_MODULE]: "+e);
        }
        /*try {
            ArrayList<SystemUserPermissionDto> permissions = new ArrayList<>();
            SystemUserPermissionDto permissionDto = new SystemUserPermissionDto();
            SystemUserPermissionIdDto permissionIdDto = new SystemUserPermissionIdDto();
            permissionIdDto.setSystemUser(systemUserService.getUserByEmail("joaopaulo1090@mail.com"));
            SystemModuleDto moduleDtoNovo = systemModuleService.findOne(1L);
            permissionIdDto.setSystemModule(moduleDtoNovo);
            permissionDto.setSystemUserPermissionId(permissionIdDto);
            permissionDto.setAdd(Boolean.TRUE);
            permissionDto.setDelete(Boolean.TRUE);
            permissionDto.setEdit(Boolean.TRUE);
            permissionDto.setRead(Boolean.TRUE);
            permissions.add(permissionDto);
            moduleDtoNovo.setSystemUserPermission(permissions);
            systemModuleService.save(moduleDtoNovo);
        } catch (Exception e) {
            System.err.println("[ERRO_SYSTEM_PERMISSION]: "+e);
        }*/
        return mav;
    }
    
    
}