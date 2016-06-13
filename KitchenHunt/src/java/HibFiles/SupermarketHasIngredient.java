package HibFiles;
// Generated Jun 12, 2016 7:31:13 PM by Hibernate Tools 4.3.1



/**
 * SupermarketHasIngredient generated by hbm2java
 */
public class SupermarketHasIngredient  implements java.io.Serializable {


     private Integer idsupermarketHasIngredientc;
     private Ingredient ingredient;
     private Supermarket supermarket;
     private String quantity;
     private String price;

    public SupermarketHasIngredient() {
    }

	
    public SupermarketHasIngredient(Ingredient ingredient, Supermarket supermarket) {
        this.ingredient = ingredient;
        this.supermarket = supermarket;
    }
    public SupermarketHasIngredient(Ingredient ingredient, Supermarket supermarket, String quantity, String price) {
       this.ingredient = ingredient;
       this.supermarket = supermarket;
       this.quantity = quantity;
       this.price = price;
    }
   
    public Integer getIdsupermarketHasIngredientc() {
        return this.idsupermarketHasIngredientc;
    }
    
    public void setIdsupermarketHasIngredientc(Integer idsupermarketHasIngredientc) {
        this.idsupermarketHasIngredientc = idsupermarketHasIngredientc;
    }
    public Ingredient getIngredient() {
        return this.ingredient;
    }
    
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    public Supermarket getSupermarket() {
        return this.supermarket;
    }
    
    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }
    public String getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getPrice() {
        return this.price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }




}


