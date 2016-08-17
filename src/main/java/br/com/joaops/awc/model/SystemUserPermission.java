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
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author João
 */
@Entity
@Table(schema = "public",
        name = "system_user_permission"
)
@AssociationOverrides({
    @AssociationOverride(name = "systemUserPermissionId.systemUser",
            joinColumns = @JoinColumn(name = "id_system_user")),
    @AssociationOverride(name = "systemUserPermissionId.systemModule",
            joinColumns = @JoinColumn(name = "id_system_module"))})
public class SystemUserPermission implements Serializable {
    
    @EmbeddedId
    private SystemUserPermissionId systemUserPermissionId;
    
    @Column(name = "read", nullable = false)
    private Boolean read;
    
    @Column(name = "add", nullable = false)
    private Boolean add;
    
    @Column(name = "edit", nullable = false)
    private Boolean edit;
    
    @Column(name = "delete", nullable = false)
    private Boolean delete;
    
    public SystemUserPermissionId getSystemUserPermissionId() {
        return systemUserPermissionId;
    }
    
    public void setSystemUserPermissionId(SystemUserPermissionId systemUserPermissionId) {
        this.systemUserPermissionId = systemUserPermissionId;
    }
    
    public Boolean getRead() {
        return read;
    }
    
    public void setRead(Boolean read) {
        this.read = read;
    }
    
    public Boolean getAdd() {
        return add;
    }
    
    public void setAdd(Boolean add) {
        this.add = add;
    }
    
    public Boolean getEdit() {
        return edit;
    }
    
    public void setEdit(Boolean edit) {
        this.edit = edit;
    }
    
    public Boolean getDelete() {
        return delete;
    }
    
    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.systemUserPermissionId);
        hash = 79 * hash + Objects.hashCode(this.read);
        hash = 79 * hash + Objects.hashCode(this.add);
        hash = 79 * hash + Objects.hashCode(this.edit);
        hash = 79 * hash + Objects.hashCode(this.delete);
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
        final SystemUserPermission other = (SystemUserPermission) obj;
        if (!Objects.equals(this.systemUserPermissionId, other.systemUserPermissionId)) {
            return false;
        }
        if (!Objects.equals(this.read, other.read)) {
            return false;
        }
        if (!Objects.equals(this.add, other.add)) {
            return false;
        }
        if (!Objects.equals(this.edit, other.edit)) {
            return false;
        }
        if (!Objects.equals(this.delete, other.delete)) {
            return false;
        }
        return true;
    }
    
}