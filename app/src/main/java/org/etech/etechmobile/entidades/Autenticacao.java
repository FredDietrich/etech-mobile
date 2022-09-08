/*
 * etech-backend
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package org.etech.etechmobile.entidades;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Autenticacao
 */

public class Autenticacao {
  @SerializedName("login")
  private String login = null;

  @SerializedName("senha")
  private String senha = null;

  public Autenticacao login(String login) {
    this.login = login;
    return this;
  }

   /**
   * Get login
   * @return login
  **/
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public Autenticacao senha(String senha) {
    this.senha = senha;
    return this;
  }

   /**
   * Get senha
   * @return senha
  **/
  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Autenticacao autenticacao = (Autenticacao) o;
    return Objects.equals(this.login, autenticacao.login) &&
        Objects.equals(this.senha, autenticacao.senha);
  }

  @Override
  public int hashCode() {
    return Objects.hash(login, senha);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Autenticacao {\n");
    
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    senha: ").append(toIndentedString(senha)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
