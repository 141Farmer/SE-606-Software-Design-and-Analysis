//Objects of a derived class must be replaceable by objects of the base class 
//without affecting the correct functioning of the program

package LiskovSubstitutionPrinciple;

abstract class Bird{ 
    public abstract void Move(); 
}

class FlyingBird extends Bird{ 
	@Override
	public void Move(){ 
		Fly(); 
	}  
	public void Fly(){ 
	    System.out.println("Flying"); 
	} 
}

class Penguin extends Bird { 
	@Override
    public void Move(){ 
		Swim(); 
	}  
    public void Swim(){ 
	    System.out.println("Swimming"); 
    } 
}