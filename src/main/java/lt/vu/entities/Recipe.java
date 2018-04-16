package lt.vu.entities;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.johnzon.mapper.JohnzonIgnore;

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

  public  List<Product> getProductList(){return  productList;}
  public  void setProductList(List<Product> products){this.productList = products;}

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

  @JoinTable(name = "RECIPE_PRODUCT", joinColumns = {
          @JoinColumn(name = "RECIPE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
          @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")})
  @ManyToMany
  @JohnzonIgnore
  private List<Product> productList = new ArrayList<>();
}
