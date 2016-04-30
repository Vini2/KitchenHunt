package HibFiles;
// Generated May 1, 2016 1:44:28 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Notification generated by hbm2java
 */
public class Notification  implements java.io.Serializable {


     private Integer idnotification;
     private User user;
     private String notification;
     private Date notificationcol;

    public Notification() {
    }

	
    public Notification(User user) {
        this.user = user;
    }
    public Notification(User user, String notification, Date notificationcol) {
       this.user = user;
       this.notification = notification;
       this.notificationcol = notificationcol;
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
    public String getNotification() {
        return this.notification;
    }
    
    public void setNotification(String notification) {
        this.notification = notification;
    }
    public Date getNotificationcol() {
        return this.notificationcol;
    }
    
    public void setNotificationcol(Date notificationcol) {
        this.notificationcol = notificationcol;
    }




}


