package HibFiles;
// Generated May 1, 2016 1:44:28 AM by Hibernate Tools 4.3.1



/**
 * RecipeHasIngredient generated by hbm2java
 */
public class RecipeHasIngredient  implements java.io.Serializable {


     private Integer idrecipeHasIngredient;
     private Ingredient ingredient;
     private Recipe recipe;
     private Double quantity;
     private Boolean maniIngredient;

    public RecipeHasIngredient() {
    }

	
    public RecipeHasIngredient(Ingredient ingredient, Recipe recipe) {
        this.ingredient = ingredient;
        this.recipe = recipe;
    }
    public RecipeHasIngredient(Ingredient ingredient, Recipe recipe, Double quantity, Boolean maniIngredient) {
       this.ingredient = ingredient;
       this.recipe = recipe;
       this.quantity = quantity;
       this.maniIngredient = maniIngredient;
    }
   
    public Integer getIdrecipeHasIngredient() {
        return this.idrecipeHasIngredient;
    }
    
    public void setIdrecipeHasIngredient(Integer idrecipeHasIngredient) {
        this.idrecipeHasIngredient = idrecipeHasIngredient;
    }
    public Ingredient getIngredient() {
        return this.ingredient;
    }
    
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    public Recipe getRecipe() {
        return this.recipe;
    }
    
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public Double getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public Boolean getManiIngredient() {
        return this.maniIngredient;
    }
    
    public void setManiIngredient(Boolean maniIngredient) {
        this.maniIngredient = maniIngredient;
    }




}


