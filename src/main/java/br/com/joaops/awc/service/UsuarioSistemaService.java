/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.service;

import br.com.joaops.awc.dto.UsuarioSistemaDto;
import br.com.joaops.awc.dto.UsuarioSistemaFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author João
 */
public interface UsuarioSistemaService {
    
    public UsuarioSistemaFormDto newSystemUser();
    public UsuarioSistemaDto save(UsuarioSistemaFormDto sysuser);
    public UsuarioSistemaDto getUserByEmail(String email);
    public Page<UsuarioSistemaDto> searchAllUsers(Pageable p);
    
}