package apitesting;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

	public class ApiTest2 {
		
	
	    
		private APIUtility apiClient;
	    private static final String BASE_URL = "https://reqres.in/api";

	    @BeforeClass
	    public void setup() {
	        apiClient = new APIUtility(BASE_URL);
	    }

	    @Test
	    public void testGetUsers() {
	    	
	        Response response = apiClient.get("/users?page=2");

	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertTrue(response.getBody().asString().contains("data"));
	    }

	    @Test
	    public void testGetSingleUser() {
	        Response response = apiClient.get("/users/2");

	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertEquals(response.jsonPath().getInt("data.id"), 2);
	    }

	    @Test
	    public void testCreateUser() {
	        String payload = "{ \"name\": \"John Doe\", \"job\": \"QA Engineer\" }";
	        Response response = apiClient.post("/users", payload);

	        Assert.assertEquals(response.getStatusCode(), 201);
	        Assert.assertEquals(response.jsonPath().getString("name"), "John Doe");
	        Assert.assertEquals(response.jsonPath().getString("job"), "QA Engineer");
	    }

	    @Test
	    public void testUpdateUser() {
	        String payload = "{ \"name\": \"Jane Doe\", \"job\": \"Senior QA\" }";
	        Response response = apiClient.put("/users/2", payload);

	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertEquals(response.jsonPath().getString("name"), "Jane Doe");
	        Assert.assertEquals(response.jsonPath().getString("job"), "Senior QA");
	    }

	    @Test
	    public void testDeleteUser() {
	        Response response = apiClient.delete("/users/2");
	        Assert.assertEquals(response.getStatusCode(), 204);
	    }
	}



