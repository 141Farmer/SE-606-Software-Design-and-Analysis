//High-level modules should not depend on low-level modules. Both should depend on abstractions

package DependencyInversionPrinciple;

interface INotification{ 
    void SendMessage(String message); 
}

class EmailService implements INotification{ 
    public void SendMessage(String message){ 
	    System.out.println("Sending email: " + message); 
    } 
}

class NotificationService{ 

    private INotification notification; 
     
    public NotificationService(INotification notification){ 
	    this.notification = notification; 
    }
    public void Notify(String message){ 
	    notification.SendMessage(message); 
    } 
}