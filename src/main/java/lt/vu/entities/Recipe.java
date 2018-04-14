package lt.vu.entities;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "RECIPE")
@NamedQueries({
        @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
        @NamedQuery(name = "Recipe.findById", query = "SELECT r FROM Recipe r WHERE r.id = :id"),
        @NamedQuery(name = "Recipe.findByName", query = "SELECT r FROM Recipe r WHERE r.title = :title")})
@EqualsAndHashCode(of = "title")
@ToString(of = {"id", "title", "description"})
public class Recipe implements Serializable{

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Size(min = 4, max = 50)
  @Column(name = "TITLE")
  private String title;

  @Size(min = 4, max = 50)
  @Column(name = "DESCRIPTION")
  private String description;
}
