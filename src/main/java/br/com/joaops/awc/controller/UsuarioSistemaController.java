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

import br.com.joaops.awc.dto.UsuarioSistemaDto;
import br.com.joaops.awc.dto.UsuarioSistemaFormDto;
import br.com.joaops.awc.service.UsuarioSistemaService;
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
@RequestMapping(value = "/teste/system/user")
public class UsuarioSistemaController {
    
    @Autowired
    private UsuarioSistemaService systemUserService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, Pageable p) {
        ModelAndView mav = new ModelAndView("/system/user/index");
        Page<UsuarioSistemaDto> page = systemUserService.searchAllUsers(p);
        mav.addObject("page", page);
        return mav;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response, Pageable p) {
        ModelAndView mav = new ModelAndView("redirect:/system/user/");
        UsuarioSistemaFormDto usuario = new UsuarioSistemaFormDto();
        usuario.setNome("João Paulo");
        usuario.setSobrenome("Siqueira");
        usuario.setEmail("joaopaulo1094@gmail.com");
        usuario.setSenha("admin");
        usuario.setConfirmaSenha("admin");
        systemUserService.save(usuario);
        return mav;
    }
    
}