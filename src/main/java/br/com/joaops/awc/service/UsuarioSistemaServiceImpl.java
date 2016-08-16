/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.service;

import br.com.joaops.awc.dto.UsuarioSistemaDto;
import br.com.joaops.awc.dto.UsuarioSistemaFormDto;
import br.com.joaops.awc.model.UsuarioSistema;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.joaops.awc.repository.UsuarioSistemaRepository;

/**
 *
 * @author João
 */
@Service("UsuarioSistemaService")
public class UsuarioSistemaServiceImpl implements UsuarioSistemaService {
    
    @Autowired
    private UsuarioSistemaRepository repository;
    
    //@Autowired
    //private PasswordEncoder encoder;//Possível Erro Aqui!!! Precisa Configurar o Spring Security
    
    @Autowired
    private Mapper mapper;
    
    @Override
    public UsuarioSistemaFormDto newSystemUser() {
        return new UsuarioSistemaFormDto();
    }
    
    @Override
    public UsuarioSistemaDto save(UsuarioSistemaFormDto sysuser) {
        UsuarioSistema user = new UsuarioSistema();
        user.setId(sysuser.getId());
        user.setNome(sysuser.getNome());
        user.setSobrenome(sysuser.getSobrenome());
        user.setEmail(sysuser.getEmail());
        user.setSenha(sysuser.getSenha());
        user = repository.save(user);
        UsuarioSistemaDto userDto = new UsuarioSistemaDto();
        mapper.map(user, userDto);
        return userDto;
    }
    
    @Transactional(readOnly = true)
    @Override
    public UsuarioSistemaDto getUserByEmail(String email) {
        UsuarioSistema user = repository.findOneByEmail(email);
        UsuarioSistemaDto userDto = null;
        if (user != null) {
            userDto = new UsuarioSistemaDto();
            mapper.map(user, userDto);
        }
        return userDto;
    }
    
    @Transactional(readOnly = true)
    @Override
    public Page<UsuarioSistemaDto> searchAllUsers(Pageable p) {
        List<UsuarioSistemaDto> users = new ArrayList<>();
        Page<UsuarioSistema> systemUsers = repository.findAll(p);
        
        for (UsuarioSistema systemUser : systemUsers) {
            UsuarioSistemaDto userDto = new UsuarioSistemaDto();
            mapper.map(systemUser, userDto);
            users.add(userDto);
        }
        
        Page<UsuarioSistemaDto> page = null;
        if (!users.isEmpty()) {
            page = new PageImpl<>(users, p, systemUsers.getTotalElements());
        }        
        return page;
    }
    
}