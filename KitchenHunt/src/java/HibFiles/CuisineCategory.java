package HibFiles;
// Generated Jun 12, 2016 7:31:13 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * CuisineCategory generated by hbm2java
 */
public class CuisineCategory  implements java.io.Serializable {


     private Integer idcuisineCategory;
     private String cuisineName;
     private Set<Recipe> recipes = new HashSet<Recipe>(0);

    public CuisineCategory() {
    }

    public CuisineCategory(String cuisineName, Set<Recipe> recipes) {
       this.cuisineName = cuisineName;
       this.recipes = recipes;
    }
   
    public Integer getIdcuisineCategory() {
        return this.idcuisineCategory;
    }
    
    public void setIdcuisineCategory(Integer idcuisineCategory) {
        this.idcuisineCategory = idcuisineCategory;
    }
    public String getCuisineName() {
        return this.cuisineName;
    }
    
    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }
    public Set<Recipe> getRecipes() {
        return this.recipes;
    }
    
    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }




}


