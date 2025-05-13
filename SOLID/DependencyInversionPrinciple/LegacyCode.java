package DependencyInversionPrinciple;

class EmailService{ 

    public void SendEmail(String message){ 
	    System.out.println("Sending email: " + message); 
    } 
}
 
class NotificationService{ 
    private EmailService emailService = new EmailService();
     
    public void Notify(String message){ 
	    emailService.SendEmail(message); 
    } 
}