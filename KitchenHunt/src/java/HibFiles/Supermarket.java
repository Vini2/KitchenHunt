package HibFiles;
// Generated May 1, 2016 1:44:28 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Supermarket generated by hbm2java
 */
public class Supermarket  implements java.io.Serializable {


     private Integer idsupermarket;
     private String supermarketName;
     private String address;
     private String telephone;
     private Set<SupermarketHasIngredient> supermarketHasIngredients = new HashSet<SupermarketHasIngredient>(0);

    public Supermarket() {
    }

    public Supermarket(String supermarketName, String address, String telephone, Set<SupermarketHasIngredient> supermarketHasIngredients) {
       this.supermarketName = supermarketName;
       this.address = address;
       this.telephone = telephone;
       this.supermarketHasIngredients = supermarketHasIngredients;
    }
   
    public Integer getIdsupermarket() {
        return this.idsupermarket;
    }
    
    public void setIdsupermarket(Integer idsupermarket) {
        this.idsupermarket = idsupermarket;
    }
    public String getSupermarketName() {
        return this.supermarketName;
    }
    
    public void setSupermarketName(String supermarketName) {
        this.supermarketName = supermarketName;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Set<SupermarketHasIngredient> getSupermarketHasIngredients() {
        return this.supermarketHasIngredients;
    }
    
    public void setSupermarketHasIngredients(Set<SupermarketHasIngredient> supermarketHasIngredients) {
        this.supermarketHasIngredients = supermarketHasIngredients;
    }




}


