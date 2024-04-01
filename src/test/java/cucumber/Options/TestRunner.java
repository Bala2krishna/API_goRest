 package cucumber.Options;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/java/features",
	glue= {"stepDefinations"}
	,plugin ={"pretty","json:target/jsonReports/cucumber-report.json","html:target/cucumber-reports"}
	//monochrome = true
	//,tags= "@tag1"
	)
public class TestRunner {
	
	/*
	
	private static ExtentReports extent;
    private static ExtentTest extentTest;

   @BeforeClass
   public static void setUp() {
       extent = new ExtentReports();
      // Configure extent reports (e.g., set report path, configuration, etc.)

      // Initialize extent test
        extentTest = extent.createTest("API Test Report");
    }

    @AfterClass
    public static void tearDown() {
        // Flush the extent reports
        extent.flush();
    }

    public static void logStep(Status status, String message) {
        extentTest.log(status, message);
    } */


}