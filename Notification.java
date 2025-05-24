// Design a notification service that sends email/message/push/....
// TO NOTE: In Future we might add new notification methods like whatsapp, telegram, etc.,
// Code it such that, the service follows SOLID principles


// Naive approach, w/o any pattern

/* 1111111111111111111111111 UNCOMMENT THIS CODE FOR NAIVE APPROACH 111111111111111111111111111 */
// abstract class NotificationSender{
//     public void send(String message){
//         System.out.println(message);
//     }
// }

// class EmailNotification extends NotificationSender{
//     EmailNotification(){
//         System.out.println("Intitialized email connection!");
//     }
//     public void send(String message){
//         System.out.println("Sent Email Notificaiton: " + message);
//     }
// }

// class SMSNotification extends NotificationSender{
//     SMSNotification(){
//         System.out.println("Intitialized SMS connection!");
//     }
//     public void send(String message){
//         System.out.println("Sent SMS Notificaiton: " + message);
//     }
// }

// class NotificationService{
//     public void sendNotification(String type, String message){
//         if(type.toUpperCase() == "EMAIL"){
//             EmailNotification emailNotification = new EmailNotification();
//             emailNotification.send(message);
//         }else if(type.toUpperCase() == "SMS"){
//             SMSNotification smsNotification = new SMSNotification();
//             smsNotification.send(message);
//         }
//     }
// }

// public class Notification {
//     public static void main(String[] args){
//         NotificationService notificationService = new NotificationService();
//         notificationService.sendNotification("EMAIL", "Good Morning");
//         notificationService.sendNotification("SMS", "Good Morning");
//     }
// }


/* 11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111 */



// Naive approach works totally fine, and this serves our core requirement of sending notification.
// But what in future, you scaled up and added 10 more notification types ?

// Let's say you got one more notificaiotn type, a dev is coding it, paralelly you got another one and another dev is working on it
// They merged at same time (too much coincidence, but with other features this might be headache..). You have to resolve the conflict

// That's one of the purposes of design patterns (to make things easier in all the ways possible)

// So, how do we resolve this ?

/* 2222222222222222222222222222 UNCOMMENT THIS CODE FOR SIMPLE FACTORY 22222222222222222222222222 */

abstract class NotificationSender{
    public void send(String message){
        System.out.println(message);
    }
}

class EmailNotification extends NotificationSender{
    EmailNotification(){
        System.out.println("Intitialized email connection!");
    }
    public void send(String message){
        System.out.println("Sent Email Notificaiton: " + message);
    }
}

class SMSNotification extends NotificationSender{
    SMSNotification(){
        System.out.println("Intitialized SMS connection!");
    }
    public void send(String message){
        System.out.println("Sent SMS Notificaiton: " + message);
    }
}

class NotificationFactory{
    public NotificationSender getNotificationSender(String type) throws IllegalArgumentException{
        if(type.toUpperCase() == "EMAIL"){
            EmailNotification emailNotification = new EmailNotification();
            return emailNotification;
        }else if(type.toUpperCase() == "SMS"){
            SMSNotification smsNotification = new SMSNotification();
            return smsNotification;
        }
        else{
            throw new IllegalArgumentException("Illegal notification type recieved");
        }
    }
}

class NotificationService{
    public void sendNotification(String type, String message){
        NotificationFactory notificationFactory = new NotificationFactory();
        NotificationSender notificationSender = notificationFactory.getNotificationSender(type);
        notificationSender.send(message);
    }
}


public class Notification {
    public static void main(String[] args){
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification("EMAIL", "Good Morning");
        notificationService.sendNotification("SMS", "Good Morning");
    }
}
