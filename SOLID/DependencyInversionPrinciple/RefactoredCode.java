//High-level modules should not depend on low-level modules. Both should depend on abstractions

package DependencyInversionPrinciple;

interface INotificationService{ 
    void SendMessage(String message); 
}

class EmailService implements INotificationService{ 
    public void SendMessage(String message){ 
	    System.out.println("Sending email: " + message); 
    } 
}

class NotificationService{ 

    private INotificationService notificationService; 
     
    public NotificationService(INotificationService notificationService){ 
	    this.notificationService = notificationService; 
    }
    public void Notify(String message){ 
	    notificationService.SendMessage(message); 
    } 
}