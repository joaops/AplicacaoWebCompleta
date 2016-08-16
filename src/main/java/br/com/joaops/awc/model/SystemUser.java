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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author João
 */
@Entity
@Table(name = "SYSTEM_USER")
public class SystemUser implements Serializable {
    
    @Id
    @Column(name = "id_system_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "account_expiration", nullable = true)
    private LocalDate accountExpiration;
    
    @Column(name = "account_can_expire", nullable = false)
    private Boolean accountCanExpire;
    
    @Column(name = "locked", nullable = false)
    private Boolean locked;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "credential_expiration", nullable = true)
    private LocalDate credentialExpiration;
    
    @Column(name = "credential_can_expire", nullable = false)
    private Boolean credentialCanExpire;
    
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemUserPermissionId.systemUser", fetch = FetchType.EAGER)
    private List<SystemUserPermission> systemUserPermission = new ArrayList<>();
    
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
    
    public LocalDate getAccountExpiration() {
        return accountExpiration;
    }
    
    public void setAccountExpiration(LocalDate accountExpiration) {
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
    
    public LocalDate getCredentialExpiration() {
        return credentialExpiration;
    }
    
    public void setCredentialExpiration(LocalDate credentialExpiration) {
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
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.middleName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + Objects.hashCode(this.accountExpiration);
        hash = 53 * hash + Objects.hashCode(this.accountCanExpire);
        hash = 53 * hash + Objects.hashCode(this.locked);
        hash = 53 * hash + Objects.hashCode(this.credentialExpiration);
        hash = 53 * hash + Objects.hashCode(this.credentialCanExpire);
        hash = 53 * hash + Objects.hashCode(this.enabled);
        hash = 53 * hash + Objects.hashCode(this.systemUserPermission);
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
    
    @Override
    public String toString() {
        return "SystemUser{" + "id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", accountExpiration=" + accountExpiration + ", accountCanExpire=" + accountCanExpire + ", locked=" + locked + ", credentialExpiration=" + credentialExpiration + ", credentialCanExpire=" + credentialCanExpire + ", enabled=" + enabled + ", systemUserPermission=" + systemUserPermission + '}';
    }
    
}