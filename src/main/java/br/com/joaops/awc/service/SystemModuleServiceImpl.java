/*
 * Copyright (C) 2016 João Paulo
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
package br.com.joaops.awc.service;

import br.com.joaops.awc.dto.SystemModuleDto;
import br.com.joaops.awc.model.SystemModule;
import br.com.joaops.awc.repository.SystemModuleRepository;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author João Paulo
 */
@Service("SystemModuleService")
public class SystemModuleServiceImpl implements SystemModuleService {
    
    @Autowired
    private SystemModuleRepository repository;
    
    @Autowired
    private Mapper mapper;
    
    @Override
    public SystemModuleDto newSystemModule() {
        return new SystemModuleDto();
    }
    
    @Override
    public SystemModuleDto save(SystemModuleDto moduleDto) {
        SystemModule module = new SystemModule();
        //module.setId(moduleDto.getId());
        module.setName(module.getName());
        module.setCategory(moduleDto.getCategory());
        //module.setSystemUserPermission((ArrayList)moduleDto.getSystemUserPermission());
        //mapper.map(module, moduleDto);
        module = repository.save(module);
        SystemModuleDto dto = new SystemModuleDto();
        mapper.map(module, dto);
        return dto;
    }
    
    @Override
    public Page<SystemModuleDto> searchAllModules(Pageable p) {
        List<SystemModuleDto> moduleDtos = new ArrayList<>();
        Page<SystemModule> modules = repository.findAll(p);
        for (SystemModule module : modules) {
            SystemModuleDto moduleDto = new SystemModuleDto();
            mapper.map(module, moduleDto);
            moduleDtos.add(moduleDto);
        }
        Page<SystemModuleDto> page = null;
        if (!moduleDtos.isEmpty()) {
            page = new PageImpl<>(moduleDtos, p, modules.getTotalElements());
        }
        return page;
    }
    
    @Override
    public SystemModuleDto findOne(Long id) {
        SystemModule module = repository.findOne(id);
        SystemModuleDto moduleDto = new SystemModuleDto();
        mapper.map(module, moduleDto);
        return moduleDto;
    }
    
}