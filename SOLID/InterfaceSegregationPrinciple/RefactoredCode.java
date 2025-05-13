//Clients should not be forced to depend on interfaces they do not use

package InterfaceSegregationPrinciple;

interface IStartable { 
    void Start();  
}
 
interface IPrintable { 
    void PrintDocument(String document); 
}

class PrinterDevice implements IStartable, IPrintable
{
    public void Start(){ 
	    System.out.println("Printer started"); 
    } 
    public void PrintDocument(String document){ 
	    System.out.println("Printing: " + document); 
    } 
}

class ScannerDevice implements IStartable{ 
    public void Start(){ 
	    System.out.println("Scanner started"); 
    }
}
