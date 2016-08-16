/*
 * Copyright (C) 2016 João
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.joaops.awc.controller;

import br.com.joaops.awc.dto.SystemUserDto;
import br.com.joaops.awc.dto.SystemUserFormDto;
import br.com.joaops.awc.service.SystemUserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author João
 */
@Controller
@RequestMapping(value = "system/user")
public class SystemUserController {
    
    @Autowired
    private SystemUserService systemUserService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, Pageable p) {
        ModelAndView mav = new ModelAndView("/system/user/index");
        Page<SystemUserDto> page = systemUserService.searchAllUsers(p);
        mav.addObject("page", page);
        return mav;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response, Pageable p) {
        ModelAndView mav = new ModelAndView("redirect:/system/user/");
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