package HibFiles;
// Generated May 1, 2016 1:44:28 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UserLogin generated by hbm2java
 */
public class UserLogin  implements java.io.Serializable {


     private Integer iduserLogin;
     private SystemStatus systemStatus;
     private User user;
     private String email;
     private String password;
     private Set<LoginSession> loginSessions = new HashSet<LoginSession>(0);

    public UserLogin() {
    }

	
    public UserLogin(SystemStatus systemStatus, User user) {
        this.systemStatus = systemStatus;
        this.user = user;
    }
    public UserLogin(SystemStatus systemStatus, User user, String email, String password, Set<LoginSession> loginSessions) {
       this.systemStatus = systemStatus;
       this.user = user;
       this.email = email;
       this.password = password;
       this.loginSessions = loginSessions;
    }
   
    public Integer getIduserLogin() {
        return this.iduserLogin;
    }
    
    public void setIduserLogin(Integer iduserLogin) {
        this.iduserLogin = iduserLogin;
    }
    public SystemStatus getSystemStatus() {
        return this.systemStatus;
    }
    
    public void setSystemStatus(SystemStatus systemStatus) {
        this.systemStatus = systemStatus;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<LoginSession> getLoginSessions() {
        return this.loginSessions;
    }
    
    public void setLoginSessions(Set<LoginSession> loginSessions) {
        this.loginSessions = loginSessions;
    }




}


