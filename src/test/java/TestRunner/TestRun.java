
package TestRunner;
 
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)

@CucumberOptions(

					//features= {".//FeaturesFiles/"},

					features= {".//FeatureFiles/hackathon.feature"},//for specific feature file

					//features= {".//Features/LoginDDTExcel.feature"},

					//features= {".//Features/Login.feature",".//Features/Registration.feature"},//want to run multiple feature file

					//features= {"@target/rerun.txt"},

					glue="stepDefinations",

					plugin= {"pretty",

							"html:reports/hackathon.html", //generates cucumber junit reports inside reports folder

							  "rerun:target/rerun.txt", //when some particular sceanrios fail then it will run the failed files

							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

							}, //used for generating the reports,executing fail scenarios


					dryRun=false,    // checks mapping between scenario steps and step definition methods

					monochrome=true,    // to avoid junk characters in output

					publish=true,   // to publish report in cucumber server

					//tags="@sanity"  // this will execute scenarios tagged with @sanity

					//tags="@regression"

				    tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression

					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression

					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression

		)
 
public class TestRun
{
 
}
