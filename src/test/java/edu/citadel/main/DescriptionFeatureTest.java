package edu.citadel.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DescriptionFeatureTest extends SpringIntegrationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @When("the client calls /info for description")
    public void the_client_issues_GET_info() throws Throwable {
        executeGet(createURIWithPort("/info"));
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(int expectedStatusCode) throws Throwable {
        int actualStatusCode = latestResponse.getStatusCode().value();
        Assertions.assertEquals(expectedStatusCode, actualStatusCode, "Incorrect status code");
    }

    @And("the client receives server description {string}")
    public void the_client_receives_server_description_body(String expectedDescription) throws Throwable {
        JsonNode jsonResponse = new ObjectMapper().readTree(latestResponse.getBody());
        String actualDescription = jsonResponse.get("app").get("description").asText();
        Assertions.assertEquals(expectedDescription, actualDescription, "Incorrect description");
    }
}
