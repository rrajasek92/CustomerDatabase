package CustomerDatabase;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;


public class Tester {

  @Test
  public static void Test() {
	  final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	  CustomerApp tester=new CustomerApp();
    
	  CustomerApp.printInfo("Ford");
	  tester.printInfo("Ford");
    // assert statements
    assertSame("Customer number: 17"+
"Dr. Kelly Shackelford"+
"4332 Barrington Court"+
"Camden AR 71701"+
"KellyTShackelford@cuvox.de"+
"Crushing grinding and polishing machine operator at Buena Vista Garden Maintenance", systemOutRule.getLog());
    
  }

} 
