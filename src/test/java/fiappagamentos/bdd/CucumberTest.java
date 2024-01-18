package fiappagamentos.bdd;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
        @ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "fiappagamentos.bdd"),
})
public class CucumberTest {

}
