package CustomerDatabase;

import static org.junit.Assert.*;

import org.junit.Test;


public class Tester {

  @Test
  public static void Test() {
	  CustomerApp tester=new CustomerApp();
    // MyClass is tested
	  CustomerApp.printInfo("Ford");

    // assert statements
    assertSame("Customer number: 17"+
"Dr. Kelly Shackelford"+
"4332 Barrington Court"+
"Camden AR 71701"+
"KellyTShackelford@cuvox.de"+
"Crushing grinding and polishing machine operator at Buena Vista Garden Maintenance", tester.printInfo("Ford"));
    
  }

} 
