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
 * Favorito
 */

public class Favorito {
  @SerializedName("idFavorito")
  private Integer idFavorito = null;

  @SerializedName("produto")
  private Produto produto = null;

  public Favorito idFavorito(Integer idFavorito) {
    this.idFavorito = idFavorito;
    return this;
  }

   /**
   * Get idFavorito
   * @return idFavorito
  **/
  public Integer getIdFavorito() {
    return idFavorito;
  }

  public void setIdFavorito(Integer idFavorito) {
    this.idFavorito = idFavorito;
  }

  public Favorito produto(Produto produto) {
    this.produto = produto;
    return this;
  }

   /**
   * Get produto
   * @return produto
  **/
  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Favorito favorito = (Favorito) o;
    return Objects.equals(this.idFavorito, favorito.idFavorito) &&
        Objects.equals(this.produto, favorito.produto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idFavorito, produto);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Favorito {\n");
    
    sb.append("    idFavorito: ").append(toIndentedString(idFavorito)).append("\n");
    sb.append("    produto: ").append(toIndentedString(produto)).append("\n");
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