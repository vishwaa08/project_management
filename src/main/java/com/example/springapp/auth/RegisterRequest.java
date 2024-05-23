package com.example.springapp.auth;

import com.example.springapp.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private Role role;
  private String username;
  
public Object getFirstName() {
	// TODO Auto-generated method stub
	return null;
}

public Object getLastName() {
	// TODO Auto-generated method stub
	return null;
}

public Object getEmail() {
	// TODO Auto-generated method stub
	return null;
}

public CharSequence getPassword() {
	// TODO Auto-generated method stub
	return null;
}

public Object getRole() {
	// TODO Auto-generated method stub
	return null;
}

public Object getUsername() {
	// TODO Auto-generated method stub
	return null;
}
}
