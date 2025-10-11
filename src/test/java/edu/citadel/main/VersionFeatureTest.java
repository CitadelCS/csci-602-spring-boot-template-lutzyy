package edu.citadel.main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VersionFeatureTest extends SpringIntegrationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @When("the client calls /info")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet(createURIWithPort("/info"));
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        int currentStatusCode = latestResponse.getStatusCode().value();
        assertThat("status code is incorrect : ", currentStatusCode, is(statusCode));
    }

    @And("the client receives server version {string}")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        JsonNode jsonResponse = objectMapper.readTree(latestResponse.getBody());
        String actualVersion = jsonResponse.get("version").asText();
        assertThat("version value is incorrect : ", actualVersion, is(version));
    }
}
