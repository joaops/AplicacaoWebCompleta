/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.repository;

import br.com.joaops.awc.model.UsuarioSistema;

/**
 *
 * @author João Paulo
 */
public interface UsuarioSistemaRepository extends PagingAndSortingRepository<UsuarioSistema, Long> {
    
    public UsuarioSistema findOneByEmail(String email);
    
}