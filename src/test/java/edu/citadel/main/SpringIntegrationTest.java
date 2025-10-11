package edu.citadel.main;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class SpringIntegrationTest {

    @LocalServerPort
    protected int port;

    @Autowired
    protected TestRestTemplate restTemplate;

    protected ResponseEntity<String> latestResponse;

    protected String createURIWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    protected void executeGet(String uri) {
        latestResponse = restTemplate.getForEntity(uri, String.class);
    }
}
