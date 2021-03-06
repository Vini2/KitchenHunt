package HibFiles;
// Generated Jun 15, 2016 6:41:39 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * HealthCategory generated by hbm2java
 */
public class HealthCategory  implements java.io.Serializable {


     private Integer idhealthCategory;
     private String categoryName;
     private Set<Recipe> recipes = new HashSet<Recipe>(0);

    public HealthCategory() {
    }

    public HealthCategory(String categoryName, Set<Recipe> recipes) {
       this.categoryName = categoryName;
       this.recipes = recipes;
    }
   
    public Integer getIdhealthCategory() {
        return this.idhealthCategory;
    }
    
    public void setIdhealthCategory(Integer idhealthCategory) {
        this.idhealthCategory = idhealthCategory;
    }
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Set<Recipe> getRecipes() {
        return this.recipes;
    }
    
    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }




}


