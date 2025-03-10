//package apitesting;
//
//import static io.restassured.RestAssured.given;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//public class ApiTest {
//
//	String baseUrl = "https://reqres.in/api";
//
//	@BeforeClass
//	public void SetUp() {
//		RestAssured.baseURI = baseUrl;
//
//	}
//
//	@Test
//	public void getUsers() {
//		Response response = given().queryParam("page", 2).when().get("/users").then().statusCode(200).extract()
//				.response();
//		System.out.println(response.jsonPath().getList("data"));
//		Assert.assertNotNull(response.jsonPath().getList("data"),"user list empty");
//
//	}
//	
//	
//	@Test
//	public void getSingle() {
//		int i = 2;
//		Response response = given().when().get("/user/"+i).then().statusCode(200).extract()
//				.response();
//		System.out.println(response.jsonPath().getList("data"));
//		int idActual = response.jsonPath().getInt("data.id");
//		Assert.assertEquals(idActual, i);
//		
//	}
//
//	@Test
//	public void testCreateUser() {
//		
//		
//		String payload =  "{\n" +
//                "    \"name\": \"morpheus\",\n" +
//                "    \"job\": \"leader\"\n" +
//                "}";
//		
//		
//		Response response = 
//				given()
//				.contentType(ContentType.JSON)
//				.body(payload)
//				.when()
//				.post("/users")
//				.then()
//				.statusCode(201)
//				.extract()
//				.response();
//		
//		Assert.assertEquals(response.jsonPath().getString("name"), "morpheus");
//		
//	}
//
//	
//	
//	
//	
//
//}
