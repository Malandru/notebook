package org.owner.finances.notebook.core.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.owner.finances.notebook.core.account.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "users")
public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer userID;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String password;
    private String roles;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    @Column(name = "account_locked", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean accountLocked;
    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean enabled;

    public User()
    {
        this.enabled = true;
        this.accountLocked = false;
        this.roles = "ROLE_USER";
    }

    @JsonIgnore
    public Integer getUserID()
    {
        return userID;
    }

    public void setUserID(Integer userID)
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

    public String getRoles()
    {
        return roles;
    }

    public void setRoles(String roles)
    {
        this.roles = roles;
    }

    public List<Account> getAccounts()
    {
        return accounts;
    }

    public void setAccounts(List<Account> accounts)
    {
        this.accounts = accounts;
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
        return null;
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
    @JsonIgnore
    public boolean isEnabled()
    {
        return this.enabled;
    }
}
