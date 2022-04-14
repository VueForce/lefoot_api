package com.lefoot.lefootbackend.payload;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {

  @Size(min = 5, max = 20)
  private String username;

  @NotBlank
  @Size(max = 60)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 8, max = 60)
  private String password;

  @NotBlank
  @Size(max = 60)
  private String fname;

  @NotBlank
  @Size(max = 60)
  private String lname;

  @NotBlank
  @Size(max = 10)
  private String status = "ATIVO";

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<String> getRole() {
    return role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}