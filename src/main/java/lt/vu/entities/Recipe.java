package lt.vu.entities;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.johnzon.mapper.JohnzonIgnore;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
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

  public  Set<Product> getProductList(){return  productList;}
  public  void setProductList(Set<Product> products){this.productList = products;}

  public  Integer getVersion(){return  version;}
  public  void setProductList(Integer version){this.version = version;}


  @Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", updatable = false)
  private Integer id;

  @Size(min = 4, max = 50)
  @Column(name = "TITLE")
  private String title;

  @Size(min = 4, max = 50)
  @Column(name = "DESCRIPTION")
  private String description;

  @Version
  @Column(name = "OPT_LOCK_VERSION")
  private Integer version;

  @JoinTable(name = "RECIPE_PRODUCT", joinColumns = {
          @JoinColumn(name = "RECIPE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
          @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")})
  @ManyToMany(cascade ={
          CascadeType.PERSIST,
          CascadeType.MERGE})
          @JohnzonIgnore
  private Set<Product> productList = new HashSet<>();
}
