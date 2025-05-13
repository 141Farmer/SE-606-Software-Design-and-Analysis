package InterfaceSegregationPrinciple;

interface IDevice{ 
    void Start(); 
    void PrintDocument(String document); 
}

class ScannerDevice implements IDevice{ 

    public void Start(){ 
	    System.out.println("Fan started"); 
    }
    
    public void PrintDocument(String document){
    } 
}
