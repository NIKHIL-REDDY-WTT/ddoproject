package com.users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Collections;

public class User {


    @Getter
    @Setter
    @EqualsAndHashCode
    @NoArgsConstructor
    @Entity
    public class Users implements UserDetails {
        @SequenceGenerator(
                name = "employee_sequence",
                sequenceName = "employee_sequence",
                allocationSize = 1
        )
        @Id
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "employee_sequence"
        )
        private Long ddoUserId;
        private Long clientId;
        private Long orgId;
        private Long employeeId;
        private String userName;
        private String password;
        private String email;
        private String key;
        private Character isAdmin;
        private Character isActive;
        private Character isReference;
        private Time created;
        private Long createdBy;
        private Time updated;
        private Long updatedBy;

        @Enumerated(EnumType.STRING)
        private UserRole userRole;
        private Boolean locked = false;
        private Boolean enabled = false;


        public Users(Long clientId, Long orgId, Long employeeId, String userName, String password, String email, String key, Character isAdmin, Character isActive, Character isReference, Time created, Long createdBy, Time updated, Long updatedBy, UserRole userRole, Boolean locked, Boolean enabled) {
            this.clientId = clientId;
            this.orgId = orgId;
            this.employeeId = employeeId;
            this.userName = userName;
            this.password = password;
            this.email = email;
            this.key = key;
            this.isAdmin = isAdmin;
            this.isActive = isActive;
            this.isReference = isReference;
            this.created = created;
            this.createdBy = createdBy;
            this.updated = updated;
            this.updatedBy = updatedBy;
            this.userRole = userRole;
            this.locked = locked;
            this.enabled = enabled;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            SimpleGrantedAuthority authority =
                    new SimpleGrantedAuthority(userRole.name());
            return Collections.singletonList(authority);
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return userName;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return !locked;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return enabled;
        }
    }
}
