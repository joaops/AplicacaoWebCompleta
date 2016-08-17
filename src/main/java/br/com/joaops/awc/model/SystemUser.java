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
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author João
 */
@Entity
@Table(schema = "public",
        name = "system_user",
        indexes = {
            @Index(name = "idx_id_system_user", columnList = "id_system_user"),
            @Index(name = "idx_email", columnList = "email")
        }
)
@SequenceGenerator(name = "SystemUserIdGenerator", sequenceName = "seq_system_user", initialValue = 1, allocationSize = 1)
public class SystemUser implements Serializable {
    
    @Id
    @Column(name = "id_system_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SystemUserIdGenerator")
    private Long id;
    
    @Column(name = "first_name", nullable = false, unique = false, length = 100)
    private String firstName;
    
    @Column(name = "middle_name", nullable = true, unique = false, length = 100)
    private String middleName;
    
    @Column(name = "last_name", nullable = false, unique = false, length = 100)
    private String lastName;
    
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "password", nullable = false, unique = false, length = 256)
    private String password;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "account_expiration", nullable = true)
    //@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @Basic(fetch = FetchType.EAGER)
    private Date accountExpiration;
    
    @Column(name = "account_can_expire", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Boolean accountCanExpire;
    
    @Column(name = "locked", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Boolean locked;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "credential_expiration", nullable = true)
    //@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @Basic(fetch = FetchType.EAGER)
    private Date credentialExpiration;
    
    @Column(name = "credential_can_expire", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Boolean credentialCanExpire;
    
    @Column(name = "enabled", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Boolean enabled;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUserPermissionId.systemUser", fetch = FetchType.EAGER)
    private List<SystemUserPermission> systemUserPermission;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getAccountExpiration() {
        return accountExpiration;
    }
    
    public void setAccountExpiration(Date accountExpiration) {
        this.accountExpiration = accountExpiration;
    }
    
    public Boolean getAccountCanExpire() {
        return accountCanExpire;
    }
    
    public void setAccountCanExpire(Boolean accountCanExpire) {
        this.accountCanExpire = accountCanExpire;
    }
    
    public Boolean getLocked() {
        return locked;
    }
    
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
    
    public Date getCredentialExpiration() {
        return credentialExpiration;
    }
    
    public void setCredentialExpiration(Date credentialExpiration) {
        this.credentialExpiration = credentialExpiration;
    }
    
    public Boolean getCredentialCanExpire() {
        return credentialCanExpire;
    }
    
    public void setCredentialCanExpire(Boolean credentialCanExpire) {
        this.credentialCanExpire = credentialCanExpire;
    }
    
    public Boolean getEnabled() {
        return enabled;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    public List<SystemUserPermission> getSystemUserPermission() {
        return systemUserPermission;
    }
    
    public void setSystemUserPermission(List<SystemUserPermission> systemUserPermission) {
        this.systemUserPermission = systemUserPermission;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.firstName);
        hash = 71 * hash + Objects.hashCode(this.middleName);
        hash = 71 * hash + Objects.hashCode(this.lastName);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.accountExpiration);
        hash = 71 * hash + Objects.hashCode(this.accountCanExpire);
        hash = 71 * hash + Objects.hashCode(this.locked);
        hash = 71 * hash + Objects.hashCode(this.credentialExpiration);
        hash = 71 * hash + Objects.hashCode(this.credentialCanExpire);
        hash = 71 * hash + Objects.hashCode(this.enabled);
        hash = 71 * hash + Objects.hashCode(this.systemUserPermission);
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
        final SystemUser other = (SystemUser) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.middleName, other.middleName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.accountExpiration, other.accountExpiration)) {
            return false;
        }
        if (!Objects.equals(this.accountCanExpire, other.accountCanExpire)) {
            return false;
        }
        if (!Objects.equals(this.locked, other.locked)) {
            return false;
        }
        if (!Objects.equals(this.credentialExpiration, other.credentialExpiration)) {
            return false;
        }
        if (!Objects.equals(this.credentialCanExpire, other.credentialCanExpire)) {
            return false;
        }
        if (!Objects.equals(this.enabled, other.enabled)) {
            return false;
        }
        if (!Objects.equals(this.systemUserPermission, other.systemUserPermission)) {
            return false;
        }
        return true;
    }
    
}