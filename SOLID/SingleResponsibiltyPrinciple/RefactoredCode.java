//Each class or module should have only ONE responsibility or reason to change


package SingleResponsibiltyPrinciple;

class CreateService{
    public void CreateUser(String name){
	    System.out.println("User: " + name + " created");
    }
}
  


class EmailService{
    public void SendWelcomeEmail(String email){
	    System.out.println("Sending welcome email to "+email);
    }
}