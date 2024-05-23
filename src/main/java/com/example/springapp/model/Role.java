package com.example.springapp.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RequiredArgsConstructor
public enum Role {
  ADMIN(Collections.emptySet()),
  MANAGER(
      Set.of(
          Permission.USER_READ,
          Permission.USER_UPDATE,
          Permission.USER_DELETE,
          Permission.USER_CREATE,
          Permission.MANAGER_READ,
          Permission.MANAGER_UPDATE,
          Permission.MANAGER_DELETE,
          Permission.MANAGER_CREATE)),
  USER(
      Set.of(
          Permission.MANAGER_READ,
          Permission.MANAGER_UPDATE,
          Permission.MANAGER_DELETE,
          Permission.MANAGER_CREATE));

  @Getter
  private final Set<Permission> permissions;

  Role(Set<Permission> of) {
	this.permissions = null;
	// TODO Auto-generated constructor stub
}

public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
        .stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
        .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return (List<SimpleGrantedAuthority>) authorities;
  }

Collection<Permission> getPermissions() {
	// TODO Auto-generated method stub
	return null;
}
}