package ru.vsu.shop.service.model;

public class UserDto {
  private Integer id;

  private String username;

  private String name;

  private String password;

  public UserDto(String username, String name) {
    this.username = username;
    this.name = name;
  }

  public UserDto(String username, String name, String password) {
    this.username = username;
    this.name = name;
    this.password = password;
  }

  public UserDto(Integer id, String username, String name, String password) {
    this.id = id;
    this.username = username;
    this.name = name;
    this.password = password;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "UserDto{" +
      "username='" + username + '\'' +
      ", name='" + name + '\'' +
      '}';
  }
}
