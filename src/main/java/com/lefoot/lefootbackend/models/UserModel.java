package com.lefoot.lefootbackend.models;

import java.util.Set;
import javax.persistence.*;
import java.util.HashSet;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(
    name = "usuarios",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
    })
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 60)
  private String username;

  @NotBlank
  @Size(max = 60)
  @Email
  private String fname;

  @NotBlank
  @Size(max = 60)
  @Email
  private String lname;

  @NotBlank
  @Size(max = 60)
  @Email
  private String status;

  @NotBlank
  @Size(max = 60)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<RoleModel> roles = new HashSet<>();

  public UserModel() {
  }

  public UserModel(
      String username,
      String email,
      String password,
      String fname,
      String lname,
      String status
  ) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.fname = fname;
    this.lname = lname;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<RoleModel> getRoles() {
    return roles;
  }

  public void setRoles(Set<RoleModel> roles) {
    this.roles = roles;
  }
}
