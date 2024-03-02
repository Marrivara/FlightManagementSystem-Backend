package com.company.organization.backend.model.Users;

import com.company.organization.backend.model.Airplane;
import com.company.organization.backend.model.Flight;
import com.company.organization.backend.model.Pilot;
import com.company.organization.backend.model.base.BaseModel;
import com.company.organization.backend.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="airlineCompany")
public class AirlineCompany extends BaseModel implements UserDetails {

    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;

    @OneToMany(mappedBy = "airlineCompany")
    @JsonIgnore
    private List<Airplane> airplanes;

    @OneToMany(mappedBy = "")
    private List<Flight> flights;

    @OneToMany(mappedBy = "airlineCompany")
    private List<Pilot> pilots;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
