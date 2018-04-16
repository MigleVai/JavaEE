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
@Table(name = "PRODUCT")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
        @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")})
@EqualsAndHashCode(of = "name")
@ToString(of = {"id", "name", "calories", "amount", "validunitl"})
public class Product implements Serializable {

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Long getCalories() {
    return calories;
  }

  public void setCalories(Long calories) {
    this.calories = calories;
  }


  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getValiduntil() {
    return validuntil;
  }

  public void setValiduntil(String validuntil){
    this.validuntil  = validuntil;
  }


  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
  public List<Recipe> getRecipeList(){return recipeList;}
  public void setRecipeList(List<Recipe> recip){this.recipeList = recip;}

  @Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Size(min = 4, max = 50)
  @Column(name = "NAME")
  private String name;

  @Column(name = "CALORIES")
  private Long calories;

  @Column(name = "AMOUNT")
  private Long amount;

  @Column(name = "VALIDUNITL")
  private String validuntil;

  @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID")
  @ManyToOne
  @JohnzonIgnore
  private Location location;

  @ManyToMany(mappedBy = "productList")
  private List<Recipe> recipeList = new ArrayList<>();

}
