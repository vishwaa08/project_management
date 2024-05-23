package com.example.springapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
  USER_READ("user:read"),
  USER_UPDATE("user:update"),
  USER_CREATE("user:create"),
  USER_DELETE("user:delete"),
  MANAGER_READ("management:read"),
  MANAGER_UPDATE("management:update"),
  MANAGER_CREATE("management:create"),
  MANAGER_DELETE("management:delete");

  Permission(String string) {
	this.permission = "";
	// TODO Auto-generated constructor stub
}

@Getter
  private final String permission;

String getPermission() {
	// TODO Auto-generated method stub
	return null;
}


}
