package com.nemo.sj.entity;

import com.nemo.sj.constant.CommonConstant;
import com.nemo.sj.constant.SecurityConstants;
import com.nemo.sj.dto.SysRoleDto;
import com.nemo.sj.dto.UserDto;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * create by Nemo
 * 2018/7/25  13:54
 */
@ToString
@Data
public class UserDetailsImpl implements UserDetails,CredentialsContainer {
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String username;
    private String password;
    private Integer status;
    private List<SysRoleDto> roleList = new ArrayList<>();

    public UserDetailsImpl(UserDto userVo) {
        this.username = userVo.getUsername();
        this.password = userVo.getPassword();
        this.status = userVo.getStatus();
        this.userId=userVo.getId();
        roleList = userVo.getRoleList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        //判空
        if (CollectionUtils.isNotEmpty(roleList)){
            for (SysRoleDto role : roleList) {
                authorityList.add(new SimpleGrantedAuthority(role.getName()));
            }
        }
        authorityList.add(new SimpleGrantedAuthority(SecurityConstants.BASE_ROLE));
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        return !CommonConstant.STATUS_NORMAL.equals(status);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRoleDto> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRoleDto> roleList) {
        this.roleList = roleList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public void eraseCredentials() {
        password="想看密码?";
    }
}
