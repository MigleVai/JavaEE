package lt.vu.usecases.mybatis.model;

public class Recipe {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.RECIPE.ID
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.RECIPE.TITLE
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.RECIPE.DESCRIPTION
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.RECIPE.ID
     *
     * @return the value of PUBLIC.RECIPE.ID
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.RECIPE.ID
     *
     * @param id the value for PUBLIC.RECIPE.ID
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.RECIPE.TITLE
     *
     * @return the value of PUBLIC.RECIPE.TITLE
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.RECIPE.TITLE
     *
     * @param title the value for PUBLIC.RECIPE.TITLE
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.RECIPE.DESCRIPTION
     *
     * @return the value of PUBLIC.RECIPE.DESCRIPTION
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.RECIPE.DESCRIPTION
     *
     * @param description the value for PUBLIC.RECIPE.DESCRIPTION
     *
     * @mbg.generated Mon Apr 16 17:11:18 EEST 2018
     */
    public void setDescription(String description) {
        this.description = description;
    }
}