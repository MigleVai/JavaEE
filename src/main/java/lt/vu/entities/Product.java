package lt.vu.entities;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
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


  public long getCalories() {
    return calories;
  }

  public void setCalories(long calories) {
    this.calories = calories;
  }


  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public java.sql.Date getValiduntil() {
    return validuntil;
  }

  public void setValiduntil(java.sql.Date validuntil) {
    this.validuntil = validuntil;
  }


  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Size(min = 4, max = 50)
  @Column(name = "NAME")
  private String name;

  @Column(name = "CALORIES")
  private long calories;

  @Column(name = "AMOUNT")
  private long amount;

  @Column(name = "VALIDUNITL")
  private java.sql.Date validuntil;

  @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID")
  @ManyToOne
  @JohnzonIgnore
  private Location location;
}
