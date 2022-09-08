package com.jpademo.jpademoexposicion.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

  @Id
  private String username;

  @Column(nullable = false)
  private String password;

  @Column
  private String nombre;

  @Column
  private String apellido;

  @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  List<Post> posts;
}
