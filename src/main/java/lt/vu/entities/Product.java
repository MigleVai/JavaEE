package lt.vu.entities;


public class Product {

  private String name;
  private long calories;
  private long amount;
  private long id;
  private java.sql.Date validuntil;
  private long locationId;


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


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Date getValiduntil() {
    return validuntil;
  }

  public void setValiduntil(java.sql.Date validuntil) {
    this.validuntil = validuntil;
  }


  public long getLocationId() {
    return locationId;
  }

  public void setLocationId(long locationId) {
    this.locationId = locationId;
  }

}
