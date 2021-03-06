package ru.vsu.shop.db.entity;

public class UserEntity {
  private Integer id;

  private String username;

  private String password;

  private String name;

  public UserEntity(String username, String name) {
    this.username = username;
    this.name = name;
  }

  public UserEntity(String username, String name, String password) {
    this.username = username;
    this.name = name;
    this.password = password;
  }

  public UserEntity(Integer id, String username, String name, String password) {
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
