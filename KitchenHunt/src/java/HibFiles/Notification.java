package HibFiles;
// Generated Jun 12, 2016 7:31:13 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Notification generated by hbm2java
 */
public class Notification  implements java.io.Serializable {


     private Integer idnotification;
     private User user;
     private String category;
     private String notification;
     private Date date;
     private String status;

    public Notification() {
    }

	
    public Notification(User user) {
        this.user = user;
    }
    public Notification(User user, String category, String notification, Date date, String status) {
       this.user = user;
       this.category = category;
       this.notification = notification;
       this.date = date;
       this.status = status;
    }
   
    public Integer getIdnotification() {
        return this.idnotification;
    }
    
    public void setIdnotification(Integer idnotification) {
        this.idnotification = idnotification;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getNotification() {
        return this.notification;
    }
    
    public void setNotification(String notification) {
        this.notification = notification;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


