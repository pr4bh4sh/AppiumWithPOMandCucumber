import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
//    retryCount = 3,
//    detailedReport = true,
//    detailedAggregatedReport = true,
//    overviewReport = true,
//    coverageReport = true,
//    jsonUsageReport = "target/cucumber-usage.json",
//    usageReport = true,
//    toPDF = true)
//@CucumberOptions(plugin = {"html:target/cucumber-html-report",
//    "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
//    "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
//    features = {"./src/test/java/features/features"},
//    glue = {"com/github/test/java/stepdef"}
//)
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-html-report.html",
    "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
    "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"})
public class RunCukesTest extends AbstractTestNGCucumberTests {

}