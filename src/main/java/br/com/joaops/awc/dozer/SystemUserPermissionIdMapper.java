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
package br.com.joaops.awc.dozer;

import br.com.joaops.awc.dto.SystemUserPermissionIdDto;
import br.com.joaops.awc.model.SystemUserPermissionId;
import org.dozer.loader.api.BeanMappingBuilder;

/**
 *
 * @author João
 */
public class SystemUserPermissionIdMapper extends BeanMappingBuilder {
    
    @Override
    protected void configure() {
        this.mapping(SystemUserPermissionId.class, SystemUserPermissionIdDto.class);
    }
    
}