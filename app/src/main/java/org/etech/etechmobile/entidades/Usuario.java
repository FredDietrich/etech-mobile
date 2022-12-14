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

import java.util.ArrayList;
import java.util.List;
/**
 * Usuario
 */

public class Usuario {
  @SerializedName("idUsuario")
  private Integer idUsuario = null;

  @SerializedName("login")
  private String login = null;

  @SerializedName("senha")
  private String senha = null;

  @SerializedName("nome")
  private String nome = null;

  @SerializedName("cpf")
  private String cpf = null;

  @SerializedName("vendedor")
  private Boolean vendedor = null;

  @SerializedName("emails")
  private List<Email> emails = null;

  @SerializedName("telefones")
  private List<Telefone> telefones = null;

  @SerializedName("enderecos")
  private List<Endereco> enderecos = null;

  @SerializedName("compras")
  private List<Compra> compras = null;

  @SerializedName("favoritos")
  private List<Favorito> favoritos = null;

  public Usuario idUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
    return this;
  }

   /**
   * Get idUsuario
   * @return idUsuario
  **/
  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Usuario login(String login) {
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

  public Usuario senha(String senha) {
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

  public Usuario nome(String nome) {
    this.nome = nome;
    return this;
  }

   /**
   * Get nome
   * @return nome
  **/
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Usuario cpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

   /**
   * Get cpf
   * @return cpf
  **/
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Usuario vendedor(Boolean vendedor) {
    this.vendedor = vendedor;
    return this;
  }

   /**
   * Get vendedor
   * @return vendedor
  **/
  public Boolean isVendedor() {
    return vendedor;
  }

  public void setVendedor(Boolean vendedor) {
    this.vendedor = vendedor;
  }

  public Usuario emails(List<Email> emails) {
    this.emails = emails;
    return this;
  }

  public Usuario addEmailsItem(Email emailsItem) {
    if (this.emails == null) {
      this.emails = new ArrayList<Email>();
    }
    this.emails.add(emailsItem);
    return this;
  }

   /**
   * Get emails
   * @return emails
  **/
  public List<Email> getEmails() {
    return emails;
  }

  public void setEmails(List<Email> emails) {
    this.emails = emails;
  }

  public Usuario telefones(List<Telefone> telefones) {
    this.telefones = telefones;
    return this;
  }

  public Usuario addTelefonesItem(Telefone telefonesItem) {
    if (this.telefones == null) {
      this.telefones = new ArrayList<Telefone>();
    }
    this.telefones.add(telefonesItem);
    return this;
  }

   /**
   * Get telefones
   * @return telefones
  **/
  public List<Telefone> getTelefones() {
    return telefones;
  }

  public void setTelefones(List<Telefone> telefones) {
    this.telefones = telefones;
  }

  public Usuario enderecos(List<Endereco> enderecos) {
    this.enderecos = enderecos;
    return this;
  }

  public Usuario addEnderecosItem(Endereco enderecosItem) {
    if (this.enderecos == null) {
      this.enderecos = new ArrayList<Endereco>();
    }
    this.enderecos.add(enderecosItem);
    return this;
  }

   /**
   * Get enderecos
   * @return enderecos
  **/
  public List<Endereco> getEnderecos() {
    return enderecos;
  }

  public void setEnderecos(List<Endereco> enderecos) {
    this.enderecos = enderecos;
  }

  public Usuario compras(List<Compra> compras) {
    this.compras = compras;
    return this;
  }

  public Usuario addComprasItem(Compra comprasItem) {
    if (this.compras == null) {
      this.compras = new ArrayList<Compra>();
    }
    this.compras.add(comprasItem);
    return this;
  }

   /**
   * Get compras
   * @return compras
  **/
  public List<Compra> getCompras() {
    return compras;
  }

  public void setCompras(List<Compra> compras) {
    this.compras = compras;
  }

  public Usuario favoritos(List<Favorito> favoritos) {
    this.favoritos = favoritos;
    return this;
  }

  public Usuario addFavoritosItem(Favorito favoritosItem) {
    if (this.favoritos == null) {
      this.favoritos = new ArrayList<Favorito>();
    }
    this.favoritos.add(favoritosItem);
    return this;
  }

   /**
   * Get favoritos
   * @return favoritos
  **/
  public List<Favorito> getFavoritos() {
    return favoritos;
  }

  public void setFavoritos(List<Favorito> favoritos) {
    this.favoritos = favoritos;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Usuario usuario = (Usuario) o;
    return Objects.equals(this.idUsuario, usuario.idUsuario) &&
        Objects.equals(this.login, usuario.login) &&
        Objects.equals(this.senha, usuario.senha) &&
        Objects.equals(this.nome, usuario.nome) &&
        Objects.equals(this.cpf, usuario.cpf) &&
        Objects.equals(this.vendedor, usuario.vendedor) &&
        Objects.equals(this.emails, usuario.emails) &&
        Objects.equals(this.telefones, usuario.telefones) &&
        Objects.equals(this.enderecos, usuario.enderecos) &&
        Objects.equals(this.compras, usuario.compras) &&
        Objects.equals(this.favoritos, usuario.favoritos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idUsuario, login, senha, nome, cpf, vendedor, emails, telefones, enderecos, compras, favoritos);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Usuario {\n");
    
    sb.append("    idUsuario: ").append(toIndentedString(idUsuario)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    senha: ").append(toIndentedString(senha)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    vendedor: ").append(toIndentedString(vendedor)).append("\n");
    sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
    sb.append("    telefones: ").append(toIndentedString(telefones)).append("\n");
    sb.append("    enderecos: ").append(toIndentedString(enderecos)).append("\n");
    sb.append("    compras: ").append(toIndentedString(compras)).append("\n");
    sb.append("    favoritos: ").append(toIndentedString(favoritos)).append("\n");
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
