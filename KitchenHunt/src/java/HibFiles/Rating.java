package HibFiles;
// Generated Jun 12, 2016 7:31:13 PM by Hibernate Tools 4.3.1



/**
 * Rating generated by hbm2java
 */
public class Rating  implements java.io.Serializable {


     private Integer idrating;
     private Recipe recipe;
     private User user;
     private Double stars;

    public Rating() {
    }

	
    public Rating(Recipe recipe, User user) {
        this.recipe = recipe;
        this.user = user;
    }
    public Rating(Recipe recipe, User user, Double stars) {
       this.recipe = recipe;
       this.user = user;
       this.stars = stars;
    }
   
    public Integer getIdrating() {
        return this.idrating;
    }
    
    public void setIdrating(Integer idrating) {
        this.idrating = idrating;
    }
    public Recipe getRecipe() {
        return this.recipe;
    }
    
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Double getStars() {
        return this.stars;
    }
    
    public void setStars(Double stars) {
        this.stars = stars;
    }




}


