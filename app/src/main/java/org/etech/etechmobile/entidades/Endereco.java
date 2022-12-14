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
 * Endereco
 */

public class Endereco {
  @SerializedName("idEndereco")
  private Integer idEndereco = null;

  @SerializedName("principal")
  private Boolean principal = null;

  @SerializedName("cep")
  private Integer cep = null;

  @SerializedName("logradouro")
  private String logradouro = null;

  @SerializedName("bairro")
  private String bairro = null;

  @SerializedName("cidade")
  private String cidade = null;

  @SerializedName("uf")
  private String uf = null;

  @SerializedName("numero")
  private Integer numero = null;

  @SerializedName("complemento")
  private String complemento = null;

  @SerializedName("referencia")
  private String referencia = null;

  public Endereco idEndereco(Integer idEndereco) {
    this.idEndereco = idEndereco;
    return this;
  }

   /**
   * Get idEndereco
   * @return idEndereco
  **/
  public Integer getIdEndereco() {
    return idEndereco;
  }

  public void setIdEndereco(Integer idEndereco) {
    this.idEndereco = idEndereco;
  }

  public Endereco principal(Boolean principal) {
    this.principal = principal;
    return this;
  }

   /**
   * Get principal
   * @return principal
  **/
  public Boolean isPrincipal() {
    return principal;
  }

  public void setPrincipal(Boolean principal) {
    this.principal = principal;
  }

  public Endereco cep(Integer cep) {
    this.cep = cep;
    return this;
  }

   /**
   * Get cep
   * minimum: 0
   * maximum: 99999999
   * @return cep
  **/
  public Integer getCep() {
    return cep;
  }

  public void setCep(Integer cep) {
    this.cep = cep;
  }

  public Endereco logradouro(String logradouro) {
    this.logradouro = logradouro;
    return this;
  }

   /**
   * Get logradouro
   * @return logradouro
  **/
  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public Endereco bairro(String bairro) {
    this.bairro = bairro;
    return this;
  }

   /**
   * Get bairro
   * @return bairro
  **/
  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public Endereco cidade(String cidade) {
    this.cidade = cidade;
    return this;
  }

   /**
   * Get cidade
   * @return cidade
  **/
  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public Endereco uf(String uf) {
    this.uf = uf;
    return this;
  }

   /**
   * Get uf
   * @return uf
  **/
  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public Endereco numero(Integer numero) {
    this.numero = numero;
    return this;
  }

   /**
   * Get numero
   * minimum: 0
   * maximum: 100000
   * @return numero
  **/
  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Endereco complemento(String complemento) {
    this.complemento = complemento;
    return this;
  }

   /**
   * Get complemento
   * @return complemento
  **/
  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public Endereco referencia(String referencia) {
    this.referencia = referencia;
    return this;
  }

   /**
   * Get referencia
   * @return referencia
  **/
  public String getReferencia() {
    return referencia;
  }

  public void setReferencia(String referencia) {
    this.referencia = referencia;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Endereco endereco = (Endereco) o;
    return Objects.equals(this.idEndereco, endereco.idEndereco) &&
        Objects.equals(this.principal, endereco.principal) &&
        Objects.equals(this.cep, endereco.cep) &&
        Objects.equals(this.logradouro, endereco.logradouro) &&
        Objects.equals(this.bairro, endereco.bairro) &&
        Objects.equals(this.cidade, endereco.cidade) &&
        Objects.equals(this.uf, endereco.uf) &&
        Objects.equals(this.numero, endereco.numero) &&
        Objects.equals(this.complemento, endereco.complemento) &&
        Objects.equals(this.referencia, endereco.referencia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEndereco, principal, cep, logradouro, bairro, cidade, uf, numero, complemento, referencia);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Endereco {\n");
    
    sb.append("    idEndereco: ").append(toIndentedString(idEndereco)).append("\n");
    sb.append("    principal: ").append(toIndentedString(principal)).append("\n");
    sb.append("    cep: ").append(toIndentedString(cep)).append("\n");
    sb.append("    logradouro: ").append(toIndentedString(logradouro)).append("\n");
    sb.append("    bairro: ").append(toIndentedString(bairro)).append("\n");
    sb.append("    cidade: ").append(toIndentedString(cidade)).append("\n");
    sb.append("    uf: ").append(toIndentedString(uf)).append("\n");
    sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
    sb.append("    complemento: ").append(toIndentedString(complemento)).append("\n");
    sb.append("    referencia: ").append(toIndentedString(referencia)).append("\n");
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
