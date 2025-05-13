package LiskovSubstitutionPrinciple;

class Bird{ 

    public void Fly(){ 
	    System.out.println("Flying"); 
    } 
}

class Penguin extends Bird{
    
    public void Fly(){
	    throw new UnsupportedOperationException("Penguins can't fly");

    }
}
