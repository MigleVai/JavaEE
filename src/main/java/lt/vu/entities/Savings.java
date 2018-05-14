package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "SAVINGS")
@NamedQueries({
        @NamedQuery(name = "Savings.findAll", query = "SELECT r FROM Savings r"),
        @NamedQuery(name = "Savings.findById", query = "SELECT r FROM Savings r WHERE r.id = :id"),
        @NamedQuery(name = "Savings.AllIds", query = "SELECT r.id FROM Savings r")})
@EqualsAndHashCode(of = "update")
@ToString(of = {"id", "amount", "update"})
public class Savings implements Serializable{
  @Column(name = "AMOUNT")
  private long amount;
  @Column(name = "UPDATE")
  private String update;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", updatable = false)
  private long id;


  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }


  public String getUpdate() {
    return update;
  }

  public void setUpdate(String update) {
    this.update = update;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
