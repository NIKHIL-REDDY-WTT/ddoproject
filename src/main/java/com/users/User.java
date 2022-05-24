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

    @Getter
    @Setter
    @EqualsAndHashCode
    @NoArgsConstructor
    @Entity
    public class User implements UserDetails {
        @SequenceGenerator(
                name = "employee_sequence",
                sequenceName = "employee_sequence",
                allocationSize = 1

        )
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "employee_sequence")
        @Column(name="ddo_user_id")
        private int ddoUserId;
        @Column(name="ddo_client_id")
        private int clientId;
        @Column(name="ddo_org_id")
        private int orgId;
        @Column(name="ddo_employee_id")
        private int employeeId;
        @Column(name="username")
        private String userName;
        @Column(name="password")
        private String password;
        @Column(name="email")
        private String email;
        @Column(name="key")
        private String key;
        @Column(name="isadmin")
        private char isadmin;
        @Column(name="isactive")
        private char isactive;
        @Column(name="isreference")
        private char isReference;
        @Column(name="created")
        private Time created;
        @Column(name="createdby")
        private int  createdBy;
        @Column(name="updated")
        private Time updated;
        @Column(name="updatedby")
        private int updatedBy;

        @Enumerated(EnumType.STRING)
        private UserRole userRole;
        private Boolean locked = false;
        private Boolean enabled = false;

        private User(int ddoUserId, int clientId, int orgId, int employeeId, String userName, String password, String email, String key, char isadmin,
                char isactive, char isReference, Time created, int createdBy, Time updated, int updatedBy, UserRole userRole, Boolean locked,
                Boolean enabled) {
            this.ddoUserId = ddoUserId;
            this.clientId = clientId;
            this.orgId = orgId;
            this.employeeId = employeeId;
            this.userName = userName;
            this.password = password;
            this.email = email;
            this.key = key;
            this.isadmin = isadmin;
            this.isactive = isactive;
            this.isReference = isReference;
            this.created = created;
            this.createdBy = createdBy;
            this.updated = updated;
            this.updatedBy = updatedBy;
            this.userRole = userRole;
            this.locked = locked;
            this.enabled = enabled;
        }

        public User(String userName, String email, String password, UserRole user) {
            this.userName=userName;
            this.email=email;
            this.password=password;
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

