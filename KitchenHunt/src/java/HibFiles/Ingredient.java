package HibFiles;
// Generated Jun 15, 2016 6:41:39 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Ingredient generated by hbm2java
 */
public class Ingredient  implements java.io.Serializable {


     private Integer idingredient;
     private String name;
     private Set<MyIngredient> myIngredients = new HashSet<MyIngredient>(0);
     private Set<SupermarketHasIngredient> supermarketHasIngredients = new HashSet<SupermarketHasIngredient>(0);
     private Set<RecipeHasIngredient> recipeHasIngredients = new HashSet<RecipeHasIngredient>(0);

    public Ingredient() {
    }

    public Ingredient(String name, Set<MyIngredient> myIngredients, Set<SupermarketHasIngredient> supermarketHasIngredients, Set<RecipeHasIngredient> recipeHasIngredients) {
       this.name = name;
       this.myIngredients = myIngredients;
       this.supermarketHasIngredients = supermarketHasIngredients;
       this.recipeHasIngredients = recipeHasIngredients;
    }
   
    public Integer getIdingredient() {
        return this.idingredient;
    }
    
    public void setIdingredient(Integer idingredient) {
        this.idingredient = idingredient;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set<MyIngredient> getMyIngredients() {
        return this.myIngredients;
    }
    
    public void setMyIngredients(Set<MyIngredient> myIngredients) {
        this.myIngredients = myIngredients;
    }
    public Set<SupermarketHasIngredient> getSupermarketHasIngredients() {
        return this.supermarketHasIngredients;
    }
    
    public void setSupermarketHasIngredients(Set<SupermarketHasIngredient> supermarketHasIngredients) {
        this.supermarketHasIngredients = supermarketHasIngredients;
    }
    public Set<RecipeHasIngredient> getRecipeHasIngredients() {
        return this.recipeHasIngredients;
    }
    
    public void setRecipeHasIngredients(Set<RecipeHasIngredient> recipeHasIngredients) {
        this.recipeHasIngredients = recipeHasIngredients;
    }




}


