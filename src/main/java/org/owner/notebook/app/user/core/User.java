package org.owner.notebook.app.user.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity(name = "users")
public class User implements UserDetails
{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_user")
    private UUID userID;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.ORDINAL)
    @CollectionTable(name = "roles")
    @Column(name = "role", nullable = false)
    private List<Role> roles;

    @Column(name = "account_locked", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean accountLocked;
    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean enabled;

    public User()
    {
        this.enabled = true;
        this.accountLocked = false;
    }

    public void addRole(Role role)
    {
        if (this.roles == null)
            this.roles = new ArrayList<>();
        this.roles.add(role);
    }

    public UUID getUserID()
    {
        return userID;
    }

    public void setUserID(UUID userID)
    {
        this.userID = userID;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

    public boolean isAccountLocked()
    {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked)
    {
        this.accountLocked = accountLocked;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    //===================================================================
    // USER DETAILS IMPLEMENTED METHODS
    //===================================================================

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }

    @Override
    @JsonIgnore
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String getUsername()
    {
        return this.username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked()
    {
        return !this.accountLocked;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return this.enabled;
    }
}
