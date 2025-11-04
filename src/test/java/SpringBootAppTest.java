import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(HelloController.class)
public class SpringBootAppTest {

    @Autowired
    private MockMvc mockMvc;

    // Test for /api/hello endpoint
    @Test
    public void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    // Test for /api/greet/{name} endpoint with valid name
    @Test
    public void testGreetEndpointWithValidName() throws Exception {
        mockMvc.perform(get("/api/greet/John"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, John!"));
    }

    // Test for /api/greet/{name} endpoint with empty name
    @Test
    public void testGreetEndpointWithEmptyName() throws Exception {
        mockMvc.perform(get("/api/greet/ "))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.message").value("Name cannot be null or empty"))
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.path").exists());
    }

    // Test for /api/message endpoint with valid message
    @Test
    public void testMessageEndpointWithValidMessage() throws Exception {
        String requestBody = "{\"message\":\"Hello Spring Boot\"}";
        
        mockMvc.perform(post("/api/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.response").value("Received: Hello Spring Boot"));
    }

    // Test for /api/message endpoint with empty message
    @Test
    public void testMessageEndpointWithEmptyMessage() throws Exception {
        String requestBody = "{\"message\":\"\"}";
        
        mockMvc.perform(post("/api/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.message").value("Message cannot be null or empty"))
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.path").exists());
    }

    // Test for /api/message endpoint with null message
    @Test
    public void testMessageEndpointWithNullMessage() throws Exception {
        String requestBody = "{\"message\":null}";
        
        mockMvc.perform(post("/api/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.message").value("Message cannot be null or empty"));
    }

    // Test for /api/message endpoint with missing message field
    @Test
    public void testMessageEndpointWithMissingMessage() throws Exception {
        String requestBody = "{}";
        
        mockMvc.perform(post("/api/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.message").value("Message cannot be null or empty"));
    }

    // Test for invalid endpoint (404)
    @Test
    public void testInvalidEndpoint() throws Exception {
        mockMvc.perform(get("/api/invalid"))
                .andExpect(status().isNotFound());
    }

    // Test for /api/greet with special characters in name
    @Test
    public void testGreetEndpointWithSpecialCharacters() throws Exception {
        mockMvc.perform(get("/api/greet/John@123"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, John@123!"));
    }

    // Test for /api/message with long message
    @Test
    public void testMessageEndpointWithLongMessage() throws Exception {
        String longMessage = "This is a very long message that should still be processed correctly by the API endpoint without any issues";
        String requestBody = "{\"message\":\"" + longMessage + "\"}";
        
        mockMvc.perform(post("/api/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.response").value("Received: " + longMessage));
    }
}
