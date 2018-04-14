package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LOCATION")
@NamedQueries({
        @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
        @NamedQuery(name = "Location.findById", query = "SELECT l FROM Location l WHERE l.id = :id"),
        @NamedQuery(name = "Location.findByName", query = "SELECT l FROM Location l WHERE l.name = :name")})
@EqualsAndHashCode(of = "name")
@ToString(of = {"id", "name"})
public class Location implements Serializable{

  //private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 4, max = 50)
    @Column(name = "NAME")
    private String name;


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @OneToMany(mappedBy = "location")
    private List<Product> productList = new ArrayList<>();
}
