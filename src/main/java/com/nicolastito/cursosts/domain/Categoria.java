package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable{
  private static final long serialVersionUID = 1l;
  
  private Integer id;
  private String name;

  public Categoria(){
  }

  public Categoria(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Categoria)) {
            return false;
        }
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}