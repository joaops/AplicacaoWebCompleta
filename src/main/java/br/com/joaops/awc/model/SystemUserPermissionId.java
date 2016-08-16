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
package br.com.joaops.awc.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author João
 */
@Embeddable
public class SystemUserPermissionId implements Serializable {
    
    @ManyToOne(fetch = FetchType.EAGER)
    private SystemUser systemUser;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private SystemModule systemModule;
    
    public SystemUser getSystemUser() {
        return systemUser;
    }
    
    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
    
    public SystemModule getSystemModule() {
        return systemModule;
    }
    
    public void setSystemModule(SystemModule systemModule) {
        this.systemModule = systemModule;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.systemUser);
        hash = 97 * hash + Objects.hashCode(this.systemModule);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SystemUserPermissionId other = (SystemUserPermissionId) obj;
        if (!Objects.equals(this.systemUser, other.systemUser)) {
            return false;
        }
        if (!Objects.equals(this.systemModule, other.systemModule)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "SystemUserPermissionId{" + "systemUser=" + systemUser + ", systemModule=" + systemModule + '}';
    }
    
}