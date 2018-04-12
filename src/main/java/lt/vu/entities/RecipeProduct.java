package lt.vu.entities;

public class RecipeProduct {

  private long recipeId;
  private long productId;
  private long amount;
  private String standart;


  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }


  public String getStandart() {
    return standart;
  }

  public void setStandart(String standart) {
    this.standart = standart;
  }

}
