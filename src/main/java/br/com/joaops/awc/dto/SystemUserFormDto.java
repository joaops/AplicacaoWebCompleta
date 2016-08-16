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
package br.com.joaops.awc.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author João
 */
public class SystemUserFormDto implements Serializable {
    
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String confirmEmail;
    private String password;
    private String confirmPassword;
    private LocalDate accountExpiration;
    private Boolean accountCanExpire = false;
    private Boolean locked = false;
    private LocalDate credentialExpiration;
    private Boolean credentialCanExpire = false;
    private Boolean enabled = false;
    
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
    
    public String getConfirmEmail() {
        return confirmEmail;
    }
    
    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.middleName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.confirmEmail);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + Objects.hashCode(this.confirmPassword);
        hash = 53 * hash + Objects.hashCode(this.accountExpiration);
        hash = 53 * hash + Objects.hashCode(this.accountCanExpire);
        hash = 53 * hash + Objects.hashCode(this.locked);
        hash = 53 * hash + Objects.hashCode(this.credentialExpiration);
        hash = 53 * hash + Objects.hashCode(this.credentialCanExpire);
        hash = 53 * hash + Objects.hashCode(this.enabled);
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
        final SystemUserFormDto other = (SystemUserFormDto) obj;
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
        if (!Objects.equals(this.confirmEmail, other.confirmEmail)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.confirmPassword, other.confirmPassword)) {
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
        return true;
    }
    
    @Override
    public String toString() {
        return "SystemUserFormDto{" + "id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", email=" + email + ", confirmEmail=" + confirmEmail + ", password=" + password + ", confirmPassword=" + confirmPassword + ", accountExpiration=" + accountExpiration + ", accountCanExpire=" + accountCanExpire + ", locked=" + locked + ", credentialExpiration=" + credentialExpiration + ", credentialCanExpire=" + credentialCanExpire + ", enabled=" + enabled + '}';
    }
    
}