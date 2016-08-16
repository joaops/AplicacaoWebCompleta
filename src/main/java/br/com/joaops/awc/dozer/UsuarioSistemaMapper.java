/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.dozer;

import br.com.joaops.awc.dto.UsuarioSistemaDto;
import br.com.joaops.awc.model.UsuarioSistema;
import org.dozer.loader.api.BeanMappingBuilder;

/**
 *
 * @author João
 */
public class UsuarioSistemaMapper extends BeanMappingBuilder {
    
    @Override
    protected void configure() {
        this.mapping(UsuarioSistema.class, UsuarioSistemaDto.class);
    }
    
}