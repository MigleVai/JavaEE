package lt.vu.usecases.mybatis.model;

import java.util.Date;
import java.util.List;

public class Product {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PRODUCT.ID
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    private Integer id;
    private Location location;
    private List<Recipe> recipes;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location loc){this.location = loc;}

    public List<Recipe> getRecipeList() {
        return recipes;
    }

    public void setRecipeList(List<Recipe> rec){this.recipes = rec;}

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PRODUCT.CALORIES
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    private Integer calories;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PRODUCT.AMOUNT
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    private Integer amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PRODUCT.VALIDUNITL
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    private String validunitl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PRODUCT.LOCATION_ID
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    private Integer locationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PRODUCT.NAME
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PRODUCT.ID
     *
     * @return the value of PUBLIC.PRODUCT.ID
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PRODUCT.ID
     *
     * @param id the value for PUBLIC.PRODUCT.ID
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PRODUCT.CALORIES
     *
     * @return the value of PUBLIC.PRODUCT.CALORIES
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public Integer getCalories() {
        return calories;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PRODUCT.CALORIES
     *
     * @param calories the value for PUBLIC.PRODUCT.CALORIES
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PRODUCT.AMOUNT
     *
     * @return the value of PUBLIC.PRODUCT.AMOUNT
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PRODUCT.AMOUNT
     *
     * @param amount the value for PUBLIC.PRODUCT.AMOUNT
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PRODUCT.VALIDUNITL
     *
     * @return the value of PUBLIC.PRODUCT.VALIDUNITL
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public String getValidunitl() {
        return validunitl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PRODUCT.VALIDUNITL
     *
     * @param validunitl the value for PUBLIC.PRODUCT.VALIDUNITL
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public void setValidunitl(String validunitl) {
        this.validunitl = validunitl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PRODUCT.LOCATION_ID
     *
     * @return the value of PUBLIC.PRODUCT.LOCATION_ID
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PRODUCT.LOCATION_ID
     *
     * @param locationId the value for PUBLIC.PRODUCT.LOCATION_ID
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PRODUCT.NAME
     *
     * @return the value of PUBLIC.PRODUCT.NAME
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PRODUCT.NAME
     *
     * @param name the value for PUBLIC.PRODUCT.NAME
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public void setName(String name) {
        this.name = name;
    }
}