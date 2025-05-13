package SingleResponsibiltyPrinciple;

class UserManager{ 

    public void CreateUser(String name){
	    System.out.println("User: " + name + " created");
    }
    
    public void SendWelcomeEmail(String email){
	    System.out.println("Sending welcome email to "+email);
    }
}