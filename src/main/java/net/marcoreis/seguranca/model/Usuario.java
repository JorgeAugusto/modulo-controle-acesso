package net.marcoreis.seguranca.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario extends Pessoa {
  @Column(unique = true)
  private String email;
  private String senha;

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
