package HibFiles;
// Generated Jun 12, 2016 7:31:13 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UserType generated by hbm2java
 */
public class UserType  implements java.io.Serializable {


     private Integer iduserType;
     private String typeName;
     private Set<User> users = new HashSet<User>(0);

    public UserType() {
    }

    public UserType(String typeName, Set<User> users) {
       this.typeName = typeName;
       this.users = users;
    }
   
    public Integer getIduserType() {
        return this.iduserType;
    }
    
    public void setIduserType(Integer iduserType) {
        this.iduserType = iduserType;
    }
    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }




}


